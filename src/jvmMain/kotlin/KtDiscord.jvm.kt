@file:OptIn(DelicateCoroutinesApi::class)

package cloud.drakon.ktdiscord

import cloud.drakon.ktdiscord.interaction.interactionresponse.InteractionCallbackType
import cloud.drakon.ktdiscord.interaction.interactionresponse.interactioncallbackdata.InteractionCallbackData
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future

actual class KtDiscord actual constructor(
    private val publicKey: String,
    private val botToken: String,
    private val applicationId: String?,
) {
    actual suspend fun createInteractionResponse(
        type: InteractionCallbackType,
        data: InteractionCallbackData,
        interactionId: String,
        interactionToken: String,
    ) = createInteractionResponseSuspend(type, data, interactionId, interactionToken)

    @JvmName("createInteractionResponse") fun createInteractionResponseAsync(
        type: InteractionCallbackType,
        data: InteractionCallbackData,
        id: String,
        token: String,
    ) = GlobalScope.future {
        createInteractionResponseSuspend(type, data, id, token)
    }

    actual suspend fun getOriginalInteractionResponse(
        applicationId: String,
        interactionToken: String,
    ) = getOriginalInteractionResponseSuspend(applicationId, interactionToken)

    @JvmName("getOriginalInteractionResponse") fun getOriginalInteractionResponseAsync(
        applicationId: String,
        interactionToken: String,
    ) = GlobalScope.future {
        getOriginalInteractionResponseSuspend(applicationId, interactionToken)
    }
}
