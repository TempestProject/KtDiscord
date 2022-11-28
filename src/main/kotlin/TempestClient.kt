package cloud.drakon.discordkt

import cloud.drakon.discordkt.channel.message.Message
import cloud.drakon.discordkt.interaction.response.InteractionResponse
import cloud.drakon.discordkt.webbook.EditWebhookMessage
import cloud.drakon.discordkt.webbook.ExecuteWebhook
import cloud.drakon.discordkt.webbook.Webhook
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.java.Java
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
import java.security.KeyFactory
import java.security.Signature
import java.security.spec.X509EncodedKeySpec
import java.util.HexFormat
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class TempestClient(
    private val applicationId: String,
    private val botToken: String,
    private val publicKey: String,
) {
    private val ktorClient = HttpClient(Java) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }

        install(DefaultRequest)
        defaultRequest {
            url("https://discord.com/api/v10/")
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

    fun validateRequest(timestamp: String, body: String, signature: String): Boolean {
        val sig: Signature = Signature.getInstance("Ed25519")
        sig.initVerify(
            KeyFactory.getInstance("Ed25519")
                .generatePublic(X509EncodedKeySpec(HexFormat.of().parseHex(publicKey)))
        )
        sig.update((timestamp + body).toByteArray())

        return sig.verify(signature.toByteArray())
    }

    /**
     * Create a response to an Interaction from the gateway. Body is an interaction response. Returns `204 No Content`.
     */
    suspend fun createInteractionResponse(
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
    suspend fun getOriginalInteractionResponse(
        interactionToken: String,
    ): Message {
        return ktorClient.get("webhooks/$applicationId/$interactionToken/messages/@original")
            .body()
    }

    /**
     * Edits the initial Interaction response.
     */
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
                setBody(createMultiPartFormDataContent(editWebhookMessage))
            }.body()
        }
    }

    /**
     * Deletes the initial Interaction response. Returns `204 No Content` on success.
     */
    suspend fun deleteOriginalInteractionResponse(interactionToken: String): HttpResponse {
        return ktorClient.delete("webhooks/$applicationId/$interactionToken/messages/@original")
    }

    /**
     * Create a followup message for an Interaction.
     *
     * `flags` can be set to `64` to mark the message as ephemeral, except when it is the first followup message to a deferred Interactions Response. In that case, the `flags` field will be ignored, and the ephemerality of the message will be determined by the `flags` value in your original ACK.
     */
    suspend fun createFollowupMessage(
        executeWebhook: ExecuteWebhook,
        interactionToken: String,
    ): Message {
        return if (executeWebhook.files == null) {
            ktorClient.post("webhooks/$applicationId/$interactionToken") {
                contentType(ContentType.Application.Json)
                setBody(executeWebhook)
            }.body()
        } else {
            ktorClient.post("webhooks/$applicationId/$interactionToken") {
                setBody(createMultiPartFormDataContent(executeWebhook))
            }.body()
        }
    }

    /**
     * Returns a followup message for an Interaction.
     */
    suspend fun getFollowupMessage(
        messageId: String,
        interactionToken: String,
    ): Message {
        return ktorClient.get("webhooks/$applicationId/$interactionToken/messages/$messageId")
            .body()
    }

    /**
     * Edits a followup message for an Interaction.
     */
    suspend fun editFollowupMessage(
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
    suspend fun deleteFollowupMessage(
        interactionToken: String,
        messageId: String,
    ): HttpResponse {
        return ktorClient.delete("webhooks/$applicationId/$interactionToken/messages/$messageId")
    }
}
