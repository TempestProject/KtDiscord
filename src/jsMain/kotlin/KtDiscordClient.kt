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
import kotlin.js.Promise
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.delay
import kotlinx.coroutines.promise
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@JsExport actual class KtDiscordClient actual constructor(
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

    //    private val rateLimit = HashMap<String, RateLimit>()
    //
    //    private fun updateRateLimits(response: HttpResponse) {
    //        rateLimit[response.headers["X-RateLimit-Bucket"] !!] = RateLimit(
    //            response.headers["X-RateLimit-Limit"] !!.toByte(),
    //            response.headers["X-RateLimit-Remaining"] !!.toByte(),
    //            response.headers["X-RateLimit-Reset"] !!.toDouble(),
    //            response.headers["X-RateLimit-Reset-After"] !!.toDouble(),
    //            response.headers["X-RateLimit-Scope"]
    //        )
    //        println("Bucket: " + rateLimit[response.headers["X-RateLimit-Bucket"] !!])
    //    }

    inner class Interaction(private val publicKey: String) {
        private fun createMultiPartFormDataContent(webhook: Webhook): MultiPartFormDataContent =
            MultiPartFormDataContent(formData {
                append("payload_json", Json.encodeToString(webhook))
                for (i in webhook.files !!) {
                    append("files[" + i.id + "]", i.bytes, Headers.build {
                        append(HttpHeaders.ContentType, i.contentType)
                        append(
                            HttpHeaders.ContentDisposition,
                            "filename=\"" + i.filename + "\""
                        )
                    })
                }
            })

        /**
         * Create a response to an Interaction from the gateway. Body is an interaction response.
         * @exception CreateInteractionResponseException if the Discord API didn't return `204 No Content`.
         */
        fun createInteractionResponse(
            interactionResponse: InteractionResponse,
            interactionId: String,
            interactionToken: String,
        ): Promise<Unit> = GlobalScope.promise {
            val response =
                ktorClient.post("interactions/$interactionId/$interactionToken/callback") {
                    contentType(ContentType.Application.Json)
                    setBody(interactionResponse)
                }

            //        updateRateLimits(response)

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
        fun getOriginalInteractionResponse(
            interactionToken: String,
        ): Promise<Message> = GlobalScope.promise {
            val response =
                ktorClient.get("webhooks/$applicationId/$interactionToken/messages/@original")

            //        updateRateLimits(response)

            if (response.status.value != 200 && response.status.value != 429) {
                throw GetOriginalInteractionResponseException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                delay(rateLimitToMilliseconds(response))
                return@promise getOriginalInteractionResponse(interactionToken).await()
            } else {
                return@promise response.body()
            }
        }

        /**
         * Edits the initial Interaction response.
         * @exception EditOriginalInteractionResponseException if the Discord API didn't return `200 OK`.
         */
        fun editOriginalInteractionResponse(
            editWebhookMessage: EditWebhookMessage, interactionToken: String,
        ): Promise<Message> = GlobalScope.promise {
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

            //        updateRateLimits(response)

            if (response.status.value != 200 && response.status.value != 429) {
                throw EditOriginalInteractionResponseException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                delay(rateLimitToMilliseconds(response))
                return@promise editOriginalInteractionResponse(
                    editWebhookMessage, interactionToken
                ).await()
            } else {
                return@promise response.body()
            }
        }

        /**
         * Deletes the initial Interaction response.
         * @exception DeleteOriginalInteractionResponseException if the Discord API didn't return `204 No Content`.
         */
        fun deleteOriginalInteractionResponse(interactionToken: String): Promise<Unit> =
            GlobalScope.promise {
                val response =
                    ktorClient.delete("webhooks/$applicationId/$interactionToken/messages/@original")

                //            updateRateLimits(response)

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
        fun createFollowupMessage(
            executeWebhook: ExecuteWebhook,
            interactionToken: String,
        ): Promise<Message> = GlobalScope.promise {
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

            //        updateRateLimits(response)

            if (response.status.value != 200 && response.status.value != 429) {
                throw CreateFollowupMessageException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                delay(rateLimitToMilliseconds(response))
                return@promise createFollowupMessage(
                    executeWebhook,
                    interactionToken,
                ).await()
            } else {
                return@promise response.body()
            }
        }

        /**
         * Returns a followup message for an Interaction.
         * @exception GetFollowupMessageException if the Discord API didn't return `200 OK`.
         */
        fun getFollowupMessage(
            messageId: String,
            interactionToken: String,
        ): Promise<Message> = GlobalScope.promise {
            val response =
                ktorClient.get("webhooks/$applicationId/$interactionToken/messages/$messageId")

            //        updateRateLimits(response)

            if (response.status.value != 200 && response.status.value != 429) {
                throw GetFollowupMessageException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                delay(rateLimitToMilliseconds(response))
                return@promise getFollowupMessage(messageId, interactionToken).await()
            } else {
                return@promise response.body()
            }
        }

        /**
         * Edits a followup message for an Interaction.
         * @exception EditFollowupMessageException if the Discord API didn't return `200 OK`.
         */
        fun editFollowupMessage(
            editWebhookMessage: EditWebhookMessage,
            interactionToken: String,
            messageId: String,
        ): Promise<Message> = GlobalScope.promise {
            val response =
                ktorClient.patch("webhooks/$applicationId/$interactionToken/messages/$messageId") {
                    contentType(ContentType.Application.Json)
                    setBody(editWebhookMessage)
                }

            //        updateRateLimits(response)

            if (response.status.value != 200 && response.status.value != 429) {
                throw EditFollowupMessageException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                delay(rateLimitToMilliseconds(response))
                return@promise editFollowupMessage(
                    editWebhookMessage,
                    interactionToken,
                    messageId,
                ).await()
            } else {
                return@promise response.body()
            }
        }

        /**
         * Deletes a followup message for an Interaction.
         * @exception DeleteFollowupMessageException if the Discord API didn't return `204 No Content`.
         */
        fun deleteFollowupMessage(
            interactionToken: String,
            messageId: String,
        ): Promise<Unit> = GlobalScope.promise {
            val response =
                ktorClient.delete("webhooks/$applicationId/$interactionToken/messages/$messageId")

            //        updateRateLimits(response)

            if (response.status.value != 204 && response.status.value != 429) {
                throw DeleteFollowupMessageException("Code: ${response.status.value}, message: ${response.body() as String}")
            } else if (response.status.value == 429) {
                delay(rateLimitToMilliseconds(response))
                deleteFollowupMessage(interactionToken, messageId)
            }
        }
    }

    inner class ApplicationCommands {
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
                                "with_localizations", "1"
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

        /**
         * Create a new global command. s command will be overwritten). Returns an application command object.
         * @exception CreateGlobalApplicationCommandException if the Discord API didn't return `200 OK` or `201 Created`.
         */
        fun createGlobalApplicationCommand(applicationCommand: ApplicationCommandCreate): Promise<ApplicationCommand> =
            GlobalScope.promise {
                val response =
                    ktorClient.post("/applications/$applicationId/commands") {
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

        /**
         * Fetch a global command for your application. Returns an application command object.
         * @exception GetGlobalApplicationCommandException if the Discord API didn't return `200 OK`.
         */
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

        /**
         * Edit a global command. Returns an application command object. All fields are optional, but any fields provided will entirely overwrite the existing values of those fields.
         * @exception EditGlobalApplicationCommandException if the Discord API didn't return `200 OK`.
         */
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

        /**
         * Deletes a global command.
         * @exception DeleteGlobalApplicationCommandException if the Discord API didn't return `204 No Content`.
         */
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

        /**
         * Takes a list of application commands, overwriting the existing global command list for this application. Returns an array of application command objects. Commands that do not already exist will count toward daily application command create limits.
         * @exception BulkOverwriteGlobalApplicationCommandsException if the Discord API didn't return `200 OK`.
         */
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
            /**
             * Fetch all of the guild commands for your application for a specific guild. Returns an array of application command objects.
             * @exception GetGuildApplicationCommandsException if the Discord API didn't return `200 OK`.
             */
            fun getGuildApplicationCommands(withLocalizations: Boolean? = null): Promise<Array<ApplicationCommand>> =
                GlobalScope.promise {
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

            /**
             * Create a new guild command. New guild commands will be available in the guild immediately. Returns an application command object.
             * @exception CreateGuildApplicationCommandException if the Discord API didn't return `200 OK` or `201 Created`.
             */
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

            /**
             * Fetch all of the guild commands for your application for a specific guild. Returns an array of application command objects.
             * @exception GetGuildApplicationCommandException if the Discord API didn't return `200 OK`.
             */
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

            /**
             * Edit a guild command. Updates for guild commands will be available immediately. Returns an application command object. All fields are optional, but any fields provided will entirely overwrite the existing values of those fields.
             * @exception EditGuildApplicationCommandException if the Discord API didn't return `200 OK`.
             */
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

            /**
             * Delete a guild command.
             * @exception DeleteGuildApplicationCommandException if the Discord API didn't return `204 No Content`.
             */
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

            /**
             * Takes a list of application commands, overwriting the existing command list for this application for the targeted guild. Returns an array of application command objects.
             * @exception BulkOverwriteGuildApplicationCommandsException if the Discord API didn't return `200 OK`.
             */
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
}
