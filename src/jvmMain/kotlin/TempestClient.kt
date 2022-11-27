package cloud.drakon.tempest

import cloud.drakon.tempest.channel.message.Message
import cloud.drakon.tempest.interaction.response.InteractionResponse
import cloud.drakon.tempest.webbook.EditWebhookMessage
import com.goterl.lazysodium.LazySodiumJava
import com.goterl.lazysodium.SodiumJava
import com.goterl.lazysodium.utils.Key
import com.goterl.lazysodium.utils.LibraryLoader
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.java.Java
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json

actual class TempestClient actual constructor(
    private val applicationId: String,
    private val botToken: String,
    private val publicKey: String,
) {
    private val lazySodium = LazySodiumJava(SodiumJava(LibraryLoader.Mode.BUNDLED_ONLY))
    private val ktorClient = HttpClient(Java) {
        install(ContentNegotiation) {
            json()
        }
        install(DefaultRequest)
        defaultRequest {
            url("https://discord.com/api/v10/")
        }
        expectSuccess = true
    }

    fun validateRequest(timestamp: String, body: String, signature: String): Boolean {
        return lazySodium.cryptoSignVerifyDetached(
            Key.fromHexString(signature).asHexString,
            timestamp + body,
            Key.fromHexString(publicKey)
        )
    }

    suspend fun createInteractionResponse(
        interactionResponse: InteractionResponse,
        interactionId: String,
        interactionToken: String
    ): HttpResponse {
        return ktorClient.post("interactions/$interactionId/$interactionToken/callback") {
            contentType(ContentType.Application.Json)
            setBody(interactionResponse)
        }
    }

    suspend fun getOriginalInteractionResponse(
        interactionToken: String
    ): Message {
        return ktorClient.get("webhooks/$applicationId/$interactionToken/messages/@original")
            .body()
    }

    suspend fun editOriginalInteractionResponse(
        editWebhookMessage: EditWebhookMessage, interactionToken: String
    ): Message {
        return ktorClient.patch("webhooks/$applicationId/$interactionToken/messages/@original") {
            contentType(ContentType.Application.Json)
            setBody(editWebhookMessage)
        }.body()
    }
}
