package cloud.drakon.ktdiscord

import cloud.drakon.ktdiscord.interaction.interactionresponse.InteractionCallbackType
import cloud.drakon.ktdiscord.interaction.interactionresponse.InteractionResponse
import cloud.drakon.ktdiscord.interaction.interactionresponse.interactioncallbackdata.InteractionCallbackData
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

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

expect class KtDiscord(
    publicKey: String,
    botToken: String,
    applicationId: Long? = null,
) {
    suspend fun createInteractionResponse(
        type: InteractionCallbackType,
        data: InteractionCallbackData,
        id: Long,
        token: String,
    )
}

internal suspend fun createInteractionResponseSuspend(
    type: InteractionCallbackType,
    data: InteractionCallbackData,
    id: Long,
    token: String,
) = ktorClient.post("interactions/$id/$token/callback") {
    contentType(ContentType.Application.Json)
    setBody(InteractionResponse(type, data))
}.let {
    if (it.status.value != 204) throw Throwable()
}
