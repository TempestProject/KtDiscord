package cloud.drakon.tempest.interaction

import cloud.drakon.tempest.KtorClient
import cloud.drakon.tempest.webhook.EditWebhookMessage
import cloud.drakon.tempest.webhook.GetWebhookMessage
import io.ktor.client.request.*

private fun getInteractionUrl(ApplicationId: Long, InteractionToken: Long): String {
    return "webhooks/$ApplicationId/$InteractionToken"
}

class TempestInteractions(private val ApplicationId: Long, private val BotToken: String) {
    suspend fun createInteractionResponse(
        InteractionResponse: InteractionResponse,
        InteractionId: Long,
        InteractionToken: Long
    ) {
        KtorClient.post(urlString = "/interactions/$InteractionId/$InteractionToken}/callback") {
            headers {
                append("Authorization", BotToken)
            }
            setBody(InteractionResponse)
        }
    }

    suspend fun getOriginalInteractionResponse(GetWebhook: GetWebhookMessage, InteractionToken: Long) {
        KtorClient.get(
            urlString = getInteractionUrl(
                ApplicationId = ApplicationId,
                InteractionToken = InteractionToken
            ) + "/messages/@original"
        ) {
            headers {
                append("Authorization", BotToken)
            }
            setBody(GetWebhook)
        }
    }

    suspend fun editOriginalInteractionResponse(EditWebhook: EditWebhookMessage, InteractionToken: Long) {
        KtorClient.patch(
            urlString = getInteractionUrl(
                ApplicationId = ApplicationId,
                InteractionToken = InteractionToken
            ) + "/messages/@original"
        ) {
            headers {
                append("Authorization", BotToken)
            }
            setBody(EditWebhook)
        }
    }

    suspend fun deleteOriginalInteractionResponse(InteractionToken: Long) {
        KtorClient.delete(
            urlString = getInteractionUrl(
                ApplicationId = ApplicationId,
                InteractionToken = InteractionToken
            ) + "/messages/@original"
        ) {
            headers {
                append("Authorization", BotToken)
            }
        }
    }

    suspend fun createFollowupMessage(GetWebhook: GetWebhookMessage, InteractionToken: Long) {
        KtorClient.get(
            urlString = getInteractionUrl(
                ApplicationId = ApplicationId,
                InteractionToken = InteractionToken
            ) + "/messages/@original"
        ) {
            headers {
                append("Authorization", BotToken)
            }
            setBody(GetWebhook)
        }
    }
}
