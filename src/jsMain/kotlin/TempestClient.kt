package cloud.drakon.tempest

import cloud.drakon.tempest.channel.message.Message
import cloud.drakon.tempest.interaction.response.InteractionResponse
import cloud.drakon.tempest.webbook.EditWebhookMessage
import cloud.drakon.tempest.webbook.ExecuteWebhook
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.delete
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.InternalAPI
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

actual class TempestClient actual constructor(
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
        }

        expectSuccess = true
    }

    /**
     * Create a response to an Interaction from the gateway. Body is an interaction response. Returns `204 No Content`.
     */
    @JsName("createInteractionResponse") suspend fun createInteractionResponse(
        interactionResponse: InteractionResponse,
        interactionId: String,
        interactionToken: String,
    ): HttpResponse {
        return ktorClient.post("interactions/$interactionId/$interactionToken/callback") {
            contentType(ContentType.Application.Json)
            setBody(interactionResponse)
        }
    }

    /**
     * Returns the initial Interaction response.
     */
    @JsName("getOriginalInteractionResponse")
    suspend fun getOriginalInteractionResponse(
        interactionToken: String,
    ): Message {
        return ktorClient.get("webhooks/$applicationId/$interactionToken/messages/@original")
            .body()
    }

    /**
     * Edits the initial Interaction response.
     */
    @JsName("editOriginalInteractionResponse")
    @OptIn(InternalAPI::class)
    suspend fun editOriginalInteractionResponse(
        editWebhookMessage: EditWebhookMessage, interactionToken: String,
    ): Message {
        return if (editWebhookMessage.files == null) {
            ktorClient.patch("webhooks/$applicationId/$interactionToken/messages/@original") {
                contentType(ContentType.Application.Json)
                setBody(editWebhookMessage)
            }.body()
        } else {
            ktorClient.patch("webhooks/$applicationId/$interactionToken/messages/@original") {
                setBody(MultiPartFormDataContent(formData {
                    append(
                        "payload_json",
                        Json.encodeToString(editWebhookMessage),

                        //                        Headers.build {
                        //                            append(
                        //                                HttpHeaders.ContentType, ContentType.Application.Json
                        //                            )
                        //                        }

                    )
                    for (i in editWebhookMessage.files) {
                        append("files[" + i.id + "]", i.bytes, Headers.build {
                            append(HttpHeaders.ContentType, i.contentType)
                            append(
                                HttpHeaders.ContentDisposition,
                                "filename=\"" + i.filename + "\""
                            )
                        })
                    }
                }))
            }.body()
        }
    }

    /**
     * Deletes the initial Interaction response. Returns `204 No Content` on success.
     */
    @JsName("deleteOriginalInteractionResponse")
    suspend fun deleteOriginalInteractionResponse(interactionToken: String): HttpResponse {
        return ktorClient.delete("webhooks/$applicationId/$interactionToken/messages/@original")
    }

    /**
     * Create a followup message for an Interaction.
     *
     * `flags` can be set to `64` to mark the message as ephemeral, except when it is the first followup message to a deferred Interactions Response. In that case, the `flags` field will be ignored, and the ephemerality of the message will be determined by the `flags` value in your original ACK.
     */
    @JsName("createFollowupMessage") suspend fun createFollowupMessage(
        executeWebhook: ExecuteWebhook,
        interactionToken: String,
    ): Message {
        return ktorClient.post("webhooks/$applicationId/$interactionToken") {
            contentType(ContentType.Application.Json)
            setBody(executeWebhook)
        }.body()
    }

    /**
     * Returns a followup message for an Interaction.
     */
    @JsName("getFollowupMessage") suspend fun getFollowupMessage(
        messageId: String,
        interactionToken: String,
    ): Message {
        return ktorClient.get("webhooks/$applicationId/$interactionToken/messages/$messageId")
            .body()
    }

    /**
     * Edits a followup message for an Interaction.
     */
    @JsName("editFollowupMessage") suspend fun editFollowupMessage(
        editWebhookMessage: EditWebhookMessage,
        interactionToken: String,
        messageId: String,
    ): Message {
        return ktorClient.patch("webhooks/$applicationId/$interactionToken/messages/$messageId") {
            contentType(ContentType.Application.Json)
            setBody(editWebhookMessage)
        }.body()
    }

    /**
     * Deletes a followup message for an Interaction. Returns `204 No Content` on success.
     */
    @JsName("deleteFollowupMessage") suspend fun deleteFollowupMessage(
        interactionToken: String,
        messageId: String,
    ): HttpResponse {
        return ktorClient.delete("webhooks/$applicationId/$interactionToken/messages/$messageId")
    }
}
