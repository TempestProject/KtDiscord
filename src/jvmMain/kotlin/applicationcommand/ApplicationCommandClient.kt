package cloud.drakon.ktdiscord.applicationcommand

import cloud.drakon.ktdiscord.VERSION
import cloud.drakon.ktdiscord.applicationcommand.exception.BulkOverwriteGlobalApplicationCommandsException
import cloud.drakon.ktdiscord.applicationcommand.exception.BulkOverwriteGuildApplicationCommandsException
import cloud.drakon.ktdiscord.applicationcommand.exception.CreateGlobalApplicationCommandException
import cloud.drakon.ktdiscord.applicationcommand.exception.CreateGuildApplicationCommandException
import cloud.drakon.ktdiscord.applicationcommand.exception.DeleteGlobalApplicationCommandException
import cloud.drakon.ktdiscord.applicationcommand.exception.DeleteGuildApplicationCommandException
import cloud.drakon.ktdiscord.applicationcommand.exception.EditGlobalApplicationCommandException
import cloud.drakon.ktdiscord.applicationcommand.exception.EditGuildApplicationCommandException
import cloud.drakon.ktdiscord.applicationcommand.exception.GetGlobalApplicationCommandException
import cloud.drakon.ktdiscord.applicationcommand.exception.GetGlobalApplicationCommandsException
import cloud.drakon.ktdiscord.applicationcommand.exception.GetGuildApplicationCommandException
import cloud.drakon.ktdiscord.applicationcommand.exception.GetGuildApplicationCommandsException
import cloud.drakon.ktdiscord.interaction.response.exception.CreateInteractionResponseException
import cloud.drakon.ktdiscord.rateLimitToMilliseconds
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.java.Java
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
import kotlinx.serialization.json.Json

actual class ApplicationCommandClient actual constructor(
    private val applicationId: String,
    private val botToken: String,
) {
    private val ktorClient = HttpClient(Java) {
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
    suspend fun getGlobalApplicationCommands(withLocalizations: Boolean? = null): Array<ApplicationCommand> {
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

        return if (response.status.value != 200 && response.status.value != 429) {
            throw GetGlobalApplicationCommandsException("Code: ${response.status.value}, message: ${response.body() as String}")
        } else if (response.status.value == 429) {
            rateLimitToMilliseconds(response)
            getGlobalApplicationCommands(withLocalizations)
        } else {
            response.body()
        }
    }

    suspend fun createGlobalApplicationCommand(applicationCommand: ApplicationCommandCreate): ApplicationCommand {
        val response = ktorClient.post("/applications/$applicationId/commands") {
            contentType(ContentType.Application.Json)
            setBody(applicationCommand)
        }

        //        updateRateLimits(response)

        return if (response.status.value != 200 && response.status.value != 201 && response.status.value != 429) {
            throw CreateGlobalApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
        } else if (response.status.value == 429) {
            rateLimitToMilliseconds(response)
            createGlobalApplicationCommand(applicationCommand)
        } else {
            response.body()
        }
    }

    suspend fun getGlobalApplicationCommand(commandId: String): ApplicationCommand {
        val response =
            ktorClient.get("/applications/$applicationId/commands/$commandId")

        //        updateRateLimits(response)

        return if (response.status.value != 200 && response.status.value != 429) {
            throw GetGlobalApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
        } else if (response.status.value == 429) {
            rateLimitToMilliseconds(response)
            getGlobalApplicationCommand(commandId)
        } else {
            response.body()
        }
    }

    suspend fun editGlobalApplicationCommand(
        commandId: String,
        applicationCommand: ApplicationCommandEdit,
    ): ApplicationCommand {
        val response =
            ktorClient.patch("/applications/$applicationId/commands/$commandId") {
                contentType(ContentType.Application.Json)
                setBody(applicationCommand)
            }

        //        updateRateLimits(response)

        return if (response.status.value != 200 && response.status.value != 429) {
            throw EditGlobalApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
        } else if (response.status.value == 429) {
            rateLimitToMilliseconds(response)
            editGlobalApplicationCommand(commandId, applicationCommand)
        } else {
            response.body()
        }
    }

    suspend fun deleteGlobalApplicationCommand(commandId: String) {
        val response =
            ktorClient.delete("/applications/$applicationId/commands/$commandId")

        //        updateRateLimits(response)

        if (response.status.value != 204 && response.status.value != 429) {
            throw DeleteGlobalApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
        } else if (response.status.value == 429) {
            rateLimitToMilliseconds(response)
            deleteGlobalApplicationCommand(commandId)
        }
    }

    suspend fun bulkOverwriteGlobalApplicationCommands(applicationCommands: Array<ApplicationCommandCreate>): Array<ApplicationCommand> {
        val response = ktorClient.put("/applications/$applicationId/commands") {
            contentType(ContentType.Application.Json)
            setBody(applicationCommands)
        }

        //        updateRateLimits(response)

        return if (response.status.value != 200 && response.status.value != 429) {
            throw BulkOverwriteGlobalApplicationCommandsException("Code: ${response.status.value}, message: ${response.body() as String}")
        } else if (response.status.value == 429) {
            rateLimitToMilliseconds(response)
            bulkOverwriteGlobalApplicationCommands(applicationCommands)
        } else {
            response.body()
        }
    }

    inner class Guild(private val guildId: String) {
        suspend fun getGuildApplicationCommands(withLocalizations: Boolean? = null): Array<ApplicationCommand> {
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

            return if (response.status.value != 200 && response.status.value != 429) {
                throw GetGuildApplicationCommandsException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                rateLimitToMilliseconds(response)
                getGuildApplicationCommands(withLocalizations)
            } else {
                response.body()
            }
        }

        suspend fun createGuildApplicationCommand(applicationCommand: ApplicationCommandCreate): ApplicationCommand {
            val response =
                ktorClient.post("/applications/$applicationId/guilds/$guildId/commands") {
                    contentType(ContentType.Application.Json)
                    setBody(applicationCommand)
                }

            //        updateRateLimits(response)

            return if (response.status.value != 200 && response.status.value != 201 && response.status.value != 429) {
                throw CreateGuildApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                rateLimitToMilliseconds(response)
                createGuildApplicationCommand(applicationCommand)
            } else {
                response.body()
            }
        }

        suspend fun getGuildApplicationCommand(commandId: String): ApplicationCommand {
            val response =
                ktorClient.get("/applications/$applicationId/guilds/$guildId/commands/$commandId")

            //        updateRateLimits(response)

            return if (response.status.value != 200 && response.status.value != 429) {
                throw GetGuildApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                rateLimitToMilliseconds(response)
                getGuildApplicationCommand(commandId)
            } else {
                response.body()
            }
        }

        suspend fun editGuildApplicationCommand(
            commandId: String,
            applicationCommand: ApplicationCommandEdit,
        ): ApplicationCommand {
            val response =
                ktorClient.patch("/applications/$applicationId/guilds/$guildId/commands/$commandId") {
                    contentType(ContentType.Application.Json)
                    setBody(applicationCommand)
                }

            //        updateRateLimits(response)

            return if (response.status.value != 200 && response.status.value != 429) {
                throw EditGuildApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                rateLimitToMilliseconds(response)
                editGuildApplicationCommand(
                    commandId, applicationCommand
                )
            } else {
                response.body()
            }
        }

        suspend fun deleteGuildApplicationCommand(commandId: String) {
            val response =
                ktorClient.delete("/applications/$applicationId/guilds/$guildId/commands/$commandId")

            //        updateRateLimits(response)

            if (response.status.value != 204 && response.status.value != 429) {
                throw DeleteGuildApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                rateLimitToMilliseconds(response)
                deleteGuildApplicationCommand(commandId)
            }
        }

        suspend fun bulkOverwriteGuildApplicationCommands(applicationCommands: Array<ApplicationCommandCreate>): Array<ApplicationCommand> {
            val response =
                ktorClient.put("/applications/$applicationId/guilds/$guildId/commands") {
                    contentType(ContentType.Application.Json)
                    setBody(applicationCommands)
                }

            //        updateRateLimits(response)

            return if (response.status.value != 200 && response.status.value != 429) {
                throw BulkOverwriteGuildApplicationCommandsException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                rateLimitToMilliseconds(response)
                bulkOverwriteGuildApplicationCommands(applicationCommands)
            } else {
                response.body()
            }
        }
    }
}
