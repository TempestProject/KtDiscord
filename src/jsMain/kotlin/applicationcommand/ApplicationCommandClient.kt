package cloud.drakon.ktdiscord.applicationcommand

import cloud.drakon.ktdiscord.VERSION
import cloud.drakon.ktdiscord.exception.BulkOverwriteGlobalApplicationCommandsException
import cloud.drakon.ktdiscord.exception.BulkOverwriteGuildApplicationCommandsException
import cloud.drakon.ktdiscord.exception.CreateGlobalApplicationCommandException
import cloud.drakon.ktdiscord.exception.CreateGuildApplicationCommandException
import cloud.drakon.ktdiscord.exception.CreateInteractionResponseException
import cloud.drakon.ktdiscord.exception.DeleteGlobalApplicationCommandException
import cloud.drakon.ktdiscord.exception.DeleteGuildApplicationCommandException
import cloud.drakon.ktdiscord.exception.EditGlobalApplicationCommandException
import cloud.drakon.ktdiscord.exception.EditGuildApplicationCommandException
import cloud.drakon.ktdiscord.exception.GetGlobalApplicationCommandException
import cloud.drakon.ktdiscord.exception.GetGlobalApplicationCommandsException
import cloud.drakon.ktdiscord.exception.GetGuildApplicationCommandException
import cloud.drakon.ktdiscord.exception.GetGuildApplicationCommandsException
import cloud.drakon.ktdiscord.rateLimitToMilliseconds
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlin.js.Promise
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.promise
import kotlinx.serialization.json.Json

@JsExport actual class ApplicationCommandClient actual constructor(
    private val applicationId: String,
    private val botToken: String,
) {
    private val ktorClient = HttpClient(Js) {
        install(UserAgent) {
            agent = "DiscordBot (https://github.com/TempestProject/KtDiscord, $VERSION)"
        }

        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }

        install(DefaultRequest) {
            url("https://discord.com/api/v10/")
            header("Authorization", "Bot $botToken")
        }
    }

    /**
     * Fetch all of the global commands for your application. Returns an array of application command objects.
     * @param withLocalizations Whether to include full localization dictionaries (`name_localizations` and `description_localizations`) in the returned objects, instead of the `name_localized` and `description_localized` fields. Default `false`.
     * @exception CreateInteractionResponseException if the Discord API didn't return `200 OK`.
     */
    fun getGlobalApplicationCommands(withLocalizations: Boolean? = null): Promise<Array<ApplicationCommand>> =
        GlobalScope.promise {
            val response = ktorClient.get("/applications/$applicationId/commands") {
                if (withLocalizations == true) {
                    url {
                        parameters.append(
                            "with_localizations", "true"
                        )
                    }
                }
            }

            //        updateRateLimits(response)

            if (response.status.value != 200 && response.status.value != 429) {
                throw GetGlobalApplicationCommandsException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                rateLimitToMilliseconds(response)
                return@promise getGlobalApplicationCommands(withLocalizations).await()
            } else {
                return@promise response.body()
            }
        }

    fun createGlobalApplicationCommand(applicationCommand: ApplicationCommandCreate): Promise<ApplicationCommand> =
        GlobalScope.promise {
            val response = ktorClient.post("/applications/$applicationId/commands") {
                contentType(ContentType.Application.Json)
                setBody(applicationCommand)
            }

            //        updateRateLimits(response)

            if (response.status.value != 200 && response.status.value != 201 && response.status.value != 429) {
                throw CreateGlobalApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                rateLimitToMilliseconds(response)
                return@promise createGlobalApplicationCommand(applicationCommand).await()
            } else {
                return@promise response.body()
            }
        }

    fun getGlobalApplicationCommand(commandId: String): Promise<ApplicationCommand> =
        GlobalScope.promise {
            val response =
                ktorClient.get("/applications/$applicationId/commands/$commandId")

            //        updateRateLimits(response)

            if (response.status.value != 200 && response.status.value != 429) {
                throw GetGlobalApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                rateLimitToMilliseconds(response)
                return@promise getGlobalApplicationCommand(commandId).await()
            } else {
                return@promise response.body()
            }
        }

    fun editGlobalApplicationCommand(
        commandId: String,
        applicationCommand: ApplicationCommandEdit,
    ): Promise<ApplicationCommand> = GlobalScope.promise {
        val response =
            ktorClient.patch("/applications/$applicationId/commands/$commandId") {
                contentType(ContentType.Application.Json)
                setBody(applicationCommand)
            }

        //        updateRateLimits(response)

        if (response.status.value != 200 && response.status.value != 429) {
            throw EditGlobalApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
        } else if (response.status.value == 429) {
            rateLimitToMilliseconds(response)
            return@promise editGlobalApplicationCommand(
                commandId, applicationCommand
            ).await()
        } else {
            return@promise response.body()
        }
    }

    fun deleteGlobalApplicationCommand(commandId: String): Promise<Unit> =
        GlobalScope.promise {
            val response =
                ktorClient.delete("/applications/$applicationId/commands/$commandId")

            //        updateRateLimits(response)

            if (response.status.value != 204 && response.status.value != 429) {
                throw DeleteGlobalApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                rateLimitToMilliseconds(response)
                deleteGlobalApplicationCommand(commandId).await()
            }
        }

    fun bulkOverwriteGlobalApplicationCommands(applicationCommands: Array<ApplicationCommandCreate>): Promise<Array<ApplicationCommand>> =
        GlobalScope.promise {
            val response = ktorClient.put("/applications/$applicationId/commands") {
                contentType(ContentType.Application.Json)
                setBody(applicationCommands)
            }

            //        updateRateLimits(response)

            if (response.status.value != 200 && response.status.value != 429) {
                throw BulkOverwriteGlobalApplicationCommandsException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                rateLimitToMilliseconds(response)
                return@promise bulkOverwriteGlobalApplicationCommands(
                    applicationCommands
                ).await()
            } else {
                return@promise response.body()
            }
        }

    inner class Guild(private val guildId: String) {
        fun getGuildApplicationCommands(withLocalizations: Boolean? = null): Promise<Array<ApplicationCommand>> =
            GlobalScope.promise {
                val response =
                    ktorClient.get("/applications/$applicationId/guilds/$guildId/commands") {
                        if (withLocalizations == true) {
                            url {
                                parameters.append(
                                    "with_localizations", "true"
                                )
                            }
                        }
                    }

                //        updateRateLimits(response)

                if (response.status.value != 200 && response.status.value != 429) {
                    throw GetGuildApplicationCommandsException("Code: ${response.status.value}, message: ${response.body() as String}")
                } else if (response.status.value == 429) {
                    rateLimitToMilliseconds(response)
                    return@promise getGuildApplicationCommands(withLocalizations).await()
                } else {
                    return@promise response.body()
                }
            }

        fun createGuildApplicationCommand(applicationCommand: ApplicationCommandCreate): Promise<ApplicationCommand> =
            GlobalScope.promise {
                val response =
                    ktorClient.post("/applications/$applicationId/guilds/$guildId/commands") {
                        contentType(ContentType.Application.Json)
                        setBody(applicationCommand)
                    }

                //        updateRateLimits(response)

                if (response.status.value != 200 && response.status.value != 201 && response.status.value != 429) {
                    throw CreateGuildApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
                } else if (response.status.value == 429) {
                    rateLimitToMilliseconds(response)
                    return@promise createGuildApplicationCommand(applicationCommand).await()
                } else {
                    return@promise response.body()
                }
            }

        fun getGuildApplicationCommand(commandId: String): Promise<ApplicationCommand> =
            GlobalScope.promise {
                val response =
                    ktorClient.get("/applications/$applicationId/guilds/$guildId/commands/$commandId")

                //        updateRateLimits(response)

                if (response.status.value != 200 && response.status.value != 429) {
                    throw GetGuildApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
                } else if (response.status.value == 429) {
                    rateLimitToMilliseconds(response)
                    return@promise getGuildApplicationCommand(commandId).await()
                } else {
                    return@promise response.body()
                }
            }

        fun editGuildApplicationCommand(
            commandId: String,
            applicationCommand: ApplicationCommandEdit,
        ): Promise<ApplicationCommand> = GlobalScope.promise {
            val response =
                ktorClient.patch("/applications/$applicationId/guilds/$guildId/commands/$commandId") {
                    contentType(ContentType.Application.Json)
                    setBody(applicationCommand)
                }

            //        updateRateLimits(response)

            if (response.status.value != 200 && response.status.value != 429) {
                throw EditGuildApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                rateLimitToMilliseconds(response)
                return@promise editGuildApplicationCommand(
                    commandId, applicationCommand
                ).await()
            } else {
                return@promise response.body()
            }
        }

        fun deleteGuildApplicationCommand(commandId: String): Promise<Unit> =
            GlobalScope.promise {
                val response =
                    ktorClient.delete("/applications/$applicationId/guilds/$guildId/commands/$commandId")

                //        updateRateLimits(response)

                if (response.status.value != 204 && response.status.value != 429) {
                    throw DeleteGuildApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
                } else if (response.status.value == 429) {
                    rateLimitToMilliseconds(response)
                    deleteGuildApplicationCommand(commandId).await()
                }
            }

        fun bulkOverwriteGuildApplicationCommands(applicationCommands: Array<ApplicationCommandCreate>): Promise<Array<ApplicationCommand>> =
            GlobalScope.promise {
                val response =
                    ktorClient.put("/applications/$applicationId/guilds/$guildId/commands") {
                        contentType(ContentType.Application.Json)
                        setBody(applicationCommands)
                    }

                //        updateRateLimits(response)

                if (response.status.value != 200 && response.status.value != 429) {
                    throw BulkOverwriteGuildApplicationCommandsException("Code: ${response.status.value}, message: ${response.body() as String}")
                } else if (response.status.value == 429) {
                    rateLimitToMilliseconds(response)
                    return@promise bulkOverwriteGuildApplicationCommands(
                        applicationCommands
                    ).await()
                } else {
                    return@promise response.body()
                }
            }
    }
}
