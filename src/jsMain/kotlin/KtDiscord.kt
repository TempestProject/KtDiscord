package cloud.drakon.ktdiscord

import cloud.drakon.ktdiscord.applicationcommand.ApplicationCommand
import cloud.drakon.ktdiscord.applicationcommand.ApplicationCommandCreate
import cloud.drakon.ktdiscord.applicationcommand.ApplicationCommandEdit
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
import cloud.drakon.ktdiscord.channel.message.Message
import cloud.drakon.ktdiscord.interaction.response.InteractionResponse
import cloud.drakon.ktdiscord.interaction.response.exception.CreateInteractionResponseException
import cloud.drakon.ktdiscord.interaction.response.exception.DeleteOriginalInteractionResponseException
import cloud.drakon.ktdiscord.interaction.response.exception.GetOriginalInteractionResponseException
import cloud.drakon.ktdiscord.webhook.EditWebhookMessage
import cloud.drakon.ktdiscord.webhook.ExecuteWebhook
import cloud.drakon.ktdiscord.webhook.Webhook
import cloud.drakon.ktdiscord.webhook.exception.CreateFollowupMessageException
import cloud.drakon.ktdiscord.webhook.exception.DeleteFollowupMessageException
import cloud.drakon.ktdiscord.webhook.exception.EditFollowupMessageException
import cloud.drakon.ktdiscord.webhook.exception.EditOriginalInteractionResponseException
import cloud.drakon.ktdiscord.webhook.exception.GetFollowupMessageException
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.delete
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

actual class KtDiscord actual constructor(
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

    actual inner class Interaction(private val publicKey: String) {
        private fun createMultiPartFormDataContent(webhook: Webhook): MultiPartFormDataContent =
            MultiPartFormDataContent(formData {
                append("payload_json", Json.encodeToString(webhook))
                for (i in webhook.files !!) {
                    append("files[${i.id}]", i.bytes, Headers.build {
                        append(HttpHeaders.ContentType, i.contentType)
                        append(
                            HttpHeaders.ContentDisposition, "filename=\"${i.filename}\""
                        )
                    })
                }
            })

        /**
         * Create a response to an Interaction from the gateway. Body is an interaction response.
         * @exception CreateInteractionResponseException if the Discord API didn't return `204 No Content`.
         */
        suspend fun createInteractionResponse(
            interactionResponse: InteractionResponse,
            interactionId: String,
            interactionToken: String,
        ) {
            val response =
                ktorClient.post("interactions/$interactionId/$interactionToken/callback") {
                    contentType(ContentType.Application.Json)
                    setBody(interactionResponse)
                }

            if (response.status.value != 204 && response.status.value != 429) {
                throw CreateInteractionResponseException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                delay(rateLimitToMilliseconds(response))
                createInteractionResponse(
                    interactionResponse, interactionId, interactionToken
                )
            }
        }

        /**
         * Returns the initial Interaction response.
         * @exception GetOriginalInteractionResponseException if the Discord API didn't return `200 OK`.
         */
        suspend fun getOriginalInteractionResponse(
            interactionToken: String,
        ): Message {
            val response =
                ktorClient.get("webhooks/$applicationId/$interactionToken/messages/@original")

            return if (response.status.value != 200 && response.status.value != 429) {
                throw GetOriginalInteractionResponseException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                delay(rateLimitToMilliseconds(response))
                getOriginalInteractionResponse(interactionToken)
            } else {
                response.body()
            }
        }

        /**
         * Edits the initial Interaction response.
         * @exception EditOriginalInteractionResponseException if the Discord API didn't return `200 OK`.
         */
        suspend fun editOriginalInteractionResponse(
            editWebhookMessage: EditWebhookMessage, interactionToken: String,
        ): Message {
            val response = if (editWebhookMessage.files == null) {
                ktorClient.patch("webhooks/$applicationId/$interactionToken/messages/@original") {
                    contentType(ContentType.Application.Json)
                    setBody(editWebhookMessage)
                }
            } else {
                ktorClient.patch("webhooks/$applicationId/$interactionToken/messages/@original") {
                    setBody(createMultiPartFormDataContent(editWebhookMessage))
                }
            }

            return if (response.status.value != 200 && response.status.value != 429) {
                throw EditOriginalInteractionResponseException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                delay(rateLimitToMilliseconds(response))
                editOriginalInteractionResponse(editWebhookMessage, interactionToken)
            } else {
                response.body()
            }
        }

        /**
         * Deletes the initial Interaction response.
         * @exception DeleteOriginalInteractionResponseException if the Discord API didn't return `204 No Content`.
         */
        suspend fun deleteOriginalInteractionResponse(interactionToken: String) {
            val response =
                ktorClient.delete("webhooks/$applicationId/$interactionToken/messages/@original")

            if (response.status.value != 204 && response.status.value != 429) {
                throw DeleteOriginalInteractionResponseException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                delay(rateLimitToMilliseconds(response))
                deleteOriginalInteractionResponse(interactionToken)
            }
        }

        /**
         * Create a followup message for an Interaction.
         *
         * `flags` can be set to `64` to mark the message as ephemeral, except when it is the first followup message to a deferred Interactions Response. In that case, the `flags` field will be ignored, and the ephemerality of the message will be determined by the `flags` value in your original ACK.
         * @exception CreateFollowupMessageException if the Discord API didn't return `200 OK`.
         */
        suspend fun createFollowupMessage(
            executeWebhook: ExecuteWebhook,
            interactionToken: String,
        ): Message {
            val response = if (executeWebhook.files == null) {
                ktorClient.post("webhooks/$applicationId/$interactionToken") {
                    contentType(
                        ContentType.Application.Json
                    )
                    setBody(executeWebhook)
                }
            } else {
                ktorClient.post("webhooks/$applicationId/$interactionToken") {
                    setBody(
                        createMultiPartFormDataContent(executeWebhook)
                    )
                }
            }

            return if (response.status.value != 200 && response.status.value != 429) {
                throw CreateFollowupMessageException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                delay(rateLimitToMilliseconds(response))
                createFollowupMessage(executeWebhook, interactionToken)
            } else {
                response.body()
            }
        }

        /**
         * Returns a followup message for an Interaction.
         * @exception GetFollowupMessageException if the Discord API didn't return `200 OK`.
         */
        suspend fun getFollowupMessage(
            messageId: String,
            interactionToken: String,
        ): Message {
            val response =
                ktorClient.get("webhooks/$applicationId/$interactionToken/messages/$messageId")

            return if (response.status.value != 200 && response.status.value != 429) {
                throw GetFollowupMessageException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                delay(rateLimitToMilliseconds(response))
                getFollowupMessage(messageId, interactionToken)
            } else {
                response.body()
            }
        }

        /**
         * Edits a followup message for an Interaction.
         * @exception EditFollowupMessageException if the Discord API didn't return `200 OK`.
         */
        suspend fun editFollowupMessage(
            editWebhookMessage: EditWebhookMessage,
            interactionToken: String,
            messageId: String,
        ): Message {
            val response =
                ktorClient.patch("webhooks/$applicationId/$interactionToken/messages/$messageId") {
                    contentType(ContentType.Application.Json)
                    setBody(editWebhookMessage)
                }

            return if (response.status.value != 200 && response.status.value != 429) {
                throw EditFollowupMessageException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                delay(rateLimitToMilliseconds(response))
                editFollowupMessage(editWebhookMessage, interactionToken, messageId)
            } else {
                response.body()
            }
        }

        /**
         * Deletes a followup message for an Interaction.
         * @exception DeleteFollowupMessageException if the Discord API didn't return `204 No Content`.
         */
        suspend fun deleteFollowupMessage(
            interactionToken: String,
            messageId: String,
        ) {
            val response =
                ktorClient.delete("webhooks/$applicationId/$interactionToken/messages/$messageId")

            if (response.status.value != 204 && response.status.value != 429) {
                throw DeleteFollowupMessageException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                delay(rateLimitToMilliseconds(response))
                deleteFollowupMessage(interactionToken, messageId)
            }
        }
    }

    actual inner class ApplicationCommands {
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
                            "with_localizations", "1"
                        )
                    }
                }
            }

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

            return if (response.status.value != 200 && response.status.value != 429) {
                throw BulkOverwriteGlobalApplicationCommandsException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                rateLimitToMilliseconds(response)
                bulkOverwriteGlobalApplicationCommands(applicationCommands)
            } else {
                response.body()
            }
        }

        actual inner class Guild(private val guildId: String) {
            /**
             * Fetch all of the guild commands for your application for a specific guild. Returns an array of application command objects.
             * @exception GetGuildApplicationCommandsException if the Discord API didn't return `200 OK`.
             */
            suspend fun getGuildApplicationCommands(withLocalizations: Boolean? = null): Array<ApplicationCommand> {
                val response =
                    ktorClient.get("/applications/$applicationId/guilds/$guildId/commands") {
                        if (withLocalizations == true) {
                            url {
                                parameters.append(
                                    "with_localizations", "1"
                                )
                            }
                        }
                    }

                return if (response.status.value != 200 && response.status.value != 429) {
                    throw GetGuildApplicationCommandsException("Code: ${response.status.value}, message: ${response.body() as String}")
                } else if (response.status.value == 429) {
                    rateLimitToMilliseconds(response)
                    getGuildApplicationCommands(withLocalizations)
                } else {
                    response.body()
                }
            }

            /**
             * Create a new guild command. New guild commands will be available in the guild immediately. Returns an application command object.
             * @exception CreateGuildApplicationCommandException if the Discord API didn't return `200 OK` or `201 Created`.
             */
            suspend fun createGuildApplicationCommand(applicationCommand: ApplicationCommandCreate): ApplicationCommand {
                val response =
                    ktorClient.post("/applications/$applicationId/guilds/$guildId/commands") {
                        contentType(ContentType.Application.Json)
                        setBody(applicationCommand)
                    }

                return if (response.status.value != 200 && response.status.value != 201 && response.status.value != 429) {
                    throw CreateGuildApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
                } else if (response.status.value == 429) {
                    rateLimitToMilliseconds(response)
                    createGuildApplicationCommand(applicationCommand)
                } else {
                    response.body()
                }
            }

            /**
             * Fetch all of the guild commands for your application for a specific guild. Returns an array of application command objects.
             * @exception GetGuildApplicationCommandException if the Discord API didn't return `200 OK`.
             */
            suspend fun getGuildApplicationCommand(commandId: String): ApplicationCommand {
                val response =
                    ktorClient.get("/applications/$applicationId/guilds/$guildId/commands/$commandId")

                return if (response.status.value != 200 && response.status.value != 429) {
                    throw GetGuildApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
                } else if (response.status.value == 429) {
                    rateLimitToMilliseconds(response)
                    getGuildApplicationCommand(commandId)
                } else {
                    response.body()
                }
            }

            /**
             * Edit a guild command. Updates for guild commands will be available immediately. Returns an application command object. All fields are optional, but any fields provided will entirely overwrite the existing values of those fields.
             * @exception EditGuildApplicationCommandException if the Discord API didn't return `200 OK`.
             */
            suspend fun editGuildApplicationCommand(
                commandId: String,
                applicationCommand: ApplicationCommandEdit,
            ): ApplicationCommand {
                val response =
                    ktorClient.patch("/applications/$applicationId/guilds/$guildId/commands/$commandId") {
                        contentType(ContentType.Application.Json)
                        setBody(applicationCommand)
                    }

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

            /**
             * Delete a guild command.
             * @exception DeleteGuildApplicationCommandException if the Discord API didn't return `204 No Content`.
             */
            suspend fun deleteGuildApplicationCommand(commandId: String) {
                val response =
                    ktorClient.delete("/applications/$applicationId/guilds/$guildId/commands/$commandId")

                if (response.status.value != 204 && response.status.value != 429) {
                    throw DeleteGuildApplicationCommandException("Code: ${response.status.value}, message: ${response.body() as String}")
                } else if (response.status.value == 429) {
                    rateLimitToMilliseconds(response)
                    deleteGuildApplicationCommand(commandId)
                }
            }

            /**
             * Takes a list of application commands, overwriting the existing command list for this application for the targeted guild. Returns an array of application command objects.
             * @exception BulkOverwriteGuildApplicationCommandsException if the Discord API didn't return `200 OK`.
             */
            suspend fun bulkOverwriteGuildApplicationCommands(applicationCommands: Array<ApplicationCommandCreate>): Array<ApplicationCommand> {
                val response =
                    ktorClient.put("/applications/$applicationId/guilds/$guildId/commands") {
                        contentType(ContentType.Application.Json)
                        setBody(applicationCommands)
                    }

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
}
