package cloud.drakon.ktdiscord

import cloud.drakon.ktdiscord.interaction.response.InteractionResponse
import cloud.drakon.ktdiscord.webhook.EditWebhookMessage
import cloud.drakon.ktdiscord.webhook.ExecuteWebhook
import cloud.drakon.ktdiscord.webhook.Webhook
import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.delete
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlin.js.Promise
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@JsExport actual class KtDiscordClient actual constructor(
    private val applicationId: String,
    private val botToken: String,
    private val publicKey: String,
) {
    private val ktorClient = HttpClient(Js) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }

        install(DefaultRequest)
        defaultRequest {
            url("https://discord.com/api/v10/")
            header(
                "User-Agent",
                "DiscordBot (https://github.com/TempestProject/KtDiscord, 1.0.2)"
            )
        }

        expectSuccess = true
    }

    private fun createMultiPartFormDataContent(webhook: Webhook): MultiPartFormDataContent {
        return MultiPartFormDataContent(formData {
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
    }

    /**
     * Create a response to an Interaction from the gateway. Body is an interaction response. Returns `204 No Content`.
     */
    fun createInteractionResponse(
        interactionResponse: InteractionResponse,
        interactionId: String,
        interactionToken: String,
    ): Promise<HttpResponse> = GlobalScope.promise {
        return@promise ktorClient.post("interactions/$interactionId/$interactionToken/callback") {
            contentType(ContentType.Application.Json)
            setBody(interactionResponse)
        }
    }

    /**
     * Returns the initial Interaction response.
     */
    fun getOriginalInteractionResponse(
        interactionToken: String,
    ): Promise<HttpResponse> = GlobalScope.promise {
        return@promise ktorClient.get("webhooks/$applicationId/$interactionToken/messages/@original")
    }

    /**
     * Edits the initial Interaction response.
     */
    fun editOriginalInteractionResponse(
        editWebhookMessage: EditWebhookMessage, interactionToken: String,
    ): Promise<HttpResponse> = GlobalScope.promise {
        return@promise if (editWebhookMessage.files == null) {
            ktorClient.patch("webhooks/$applicationId/$interactionToken/messages/@original") {
                contentType(ContentType.Application.Json)
                setBody(editWebhookMessage)
            }
        } else {
            ktorClient.patch("webhooks/$applicationId/$interactionToken/messages/@original") {
                setBody(createMultiPartFormDataContent(editWebhookMessage))
            }
        }
    }

    /**
     * Deletes the initial Interaction response. Returns `204 No Content` on success.
     */
    fun deleteOriginalInteractionResponse(interactionToken: String): Promise<HttpResponse> =
        GlobalScope.promise {
            return@promise ktorClient.delete("webhooks/$applicationId/$interactionToken/messages/@original")
        }

    /**
     * Create a followup message for an Interaction.
     *
     * `flags` can be set to `64` to mark the message as ephemeral, except when it is the first followup message to a deferred Interactions Response. In that case, the `flags` field will be ignored, and the ephemerality of the message will be determined by the `flags` value in your original ACK.
     */
    fun createFollowupMessage(
        executeWebhook: ExecuteWebhook,
        interactionToken: String,
    ): Promise<HttpResponse> = GlobalScope.promise {
        return@promise if (executeWebhook.files == null) {
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
    }

    /**
     * Returns a followup message for an Interaction.
     */
    fun getFollowupMessage(
        messageId: String,
        interactionToken: String,
    ): Promise<HttpResponse> = GlobalScope.promise {
        return@promise ktorClient.get("webhooks/$applicationId/$interactionToken/messages/$messageId")
    }

    /**
     * Edits a followup message for an Interaction.
     */
    fun editFollowupMessage(
        editWebhookMessage: EditWebhookMessage,
        interactionToken: String,
        messageId: String,
    ): Promise<HttpResponse> = GlobalScope.promise {
        return@promise ktorClient.patch("webhooks/$applicationId/$interactionToken/messages/$messageId") {
            contentType(ContentType.Application.Json)
            setBody(editWebhookMessage)
        }
    }

    /**
     * Deletes a followup message for an Interaction. Returns `204 No Content` on success.
     */
    fun deleteFollowupMessage(
        interactionToken: String,
        messageId: String,
    ): Promise<HttpResponse> = GlobalScope.promise {
        return@promise ktorClient.delete("webhooks/$applicationId/$interactionToken/messages/$messageId")
    }
}
