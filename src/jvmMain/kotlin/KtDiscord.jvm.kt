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
    private val applicationId: Long?,
) {
    actual suspend fun createInteractionResponse(
        type: InteractionCallbackType,
        data: InteractionCallbackData,
        id: Long,
        token: String,
    ) = createInteractionResponseSuspend(type, data, id, token)

    @JvmName("createInteractionResponse") fun createInteractionResponseAsync(
        type: InteractionCallbackType,
        data: InteractionCallbackData,
        id: Long,
        token: String,
    ) = GlobalScope.future {
        createInteractionResponseSuspend(type, data, id, token)
    }
}
