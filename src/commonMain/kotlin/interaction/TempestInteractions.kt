package cloud.drakon.tempest.interaction

import cloud.drakon.tempest.KtorClient
import cloud.drakon.tempest.webhook.EditWebhookMessage
import cloud.drakon.tempest.webhook.GetWebhookMessage
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.setBody

private fun getInteractionUrl(ApplicationId: Long, InteractionToken: Long): String {
    return "webhooks/$ApplicationId/$InteractionToken"
}

/**
 * @property ApplicationId Discord Application ID
 * @property BotToken Discord Bot Token
 */
class TempestInteractions(
    private val ApplicationId: Long,
    private val BotToken: String,
) {
    /** Create a response to an Interaction from the gateway. Body is an interaction response. Returns 204 No Content. */
    suspend fun createInteractionResponse(
        InteractionResponse: InteractionResponse,
        InteractionId: Long,
        InteractionToken: Long,
    ) {
        KtorClient.post(urlString = "/interactions/$InteractionId/$InteractionToken}/callback") {
            headers {
                append("Authorization", BotToken)
            }
            setBody(InteractionResponse)
        }
    }

    /** Returns the initial Interaction response. */
    suspend fun getOriginalInteractionResponse(
        GetWebhook: GetWebhookMessage,
        InteractionToken: Long,
    ) {
        KtorClient.get(
            urlString = getInteractionUrl(
                ApplicationId = ApplicationId, InteractionToken = InteractionToken
            ) + "/messages/@original"
        ) {
            headers {
                append("Authorization", BotToken)
            }
            setBody(GetWebhook)
        }
    }

    /** Edits the initial Interaction response. */
    suspend fun editOriginalInteractionResponse(
        EditWebhook: EditWebhookMessage,
        InteractionToken: Long,
    ) {
        KtorClient.patch(
            urlString = getInteractionUrl(
                ApplicationId = ApplicationId, InteractionToken = InteractionToken
            ) + "/messages/@original"
        ) {
            headers {
                append("Authorization", BotToken)
            }
            setBody(EditWebhook)
        }
    }

    /** Deletes the initial Interaction response. Returns 204 No Content on success. */
    suspend fun deleteOriginalInteractionResponse(InteractionToken: Long) {
        KtorClient.delete(
            urlString = getInteractionUrl(
                ApplicationId = ApplicationId, InteractionToken = InteractionToken
            ) + "/messages/@original"
        ) {
            headers {
                append("Authorization", BotToken)
            }
        }
    }

    /** Create a followup message for an Interaction. */
    suspend fun createFollowupMessage(
        GetWebhook: GetWebhookMessage,
        InteractionToken: Long,
    ) {
        KtorClient.get(
            urlString = getInteractionUrl(
                ApplicationId = ApplicationId, InteractionToken = InteractionToken
            ) + "/messages/@original"
        ) {
            headers {
                append("Authorization", BotToken)
            }
            setBody(GetWebhook)
        }
    }
}
