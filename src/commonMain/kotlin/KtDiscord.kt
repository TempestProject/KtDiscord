package cloud.drakon.ktdiscord

import cloud.drakon.ktdiscord.interaction.interactionresponse.InteractionCallbackType
import cloud.drakon.ktdiscord.interaction.interactionresponse.InteractionResponse
import cloud.drakon.ktdiscord.interaction.interactionresponse.interactioncallbackdata.InteractionCallbackData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtDiscord(
    publicKey: String,
    botToken: String,
    applicationId: String? = null,
) {
    private val ktorClient = HttpClient {
        defaultRequest {
            url("https://discord.com/api/v10/")
        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun createInteractionResponse(
        type: InteractionCallbackType,
        data: InteractionCallbackData,
        interactionId: String,
        interactionToken: String,
    ) = ktorClient.post("interactions/$interactionId/$interactionToken/callback") {
        contentType(ContentType.Application.Json)
        setBody(InteractionResponse(type, data))
    }.let {
        if (it.status.value != 204) throw Throwable()
    }

    suspend fun getOriginalInteractionResponse(
        applicationId: String,
        interactionToken: String,
    ): String = ktorClient.get(
        "webhooks/$applicationId}/$interactionToken}/messages/@original"
    ).let {
        when (it.status.value) {
            200  -> it.body()
            else -> throw Throwable()
        }
    }
}
