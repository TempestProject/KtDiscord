@file:OptIn(DelicateCoroutinesApi::class, ExperimentalJsExport::class)

package cloud.drakon.ktdiscord

import cloud.drakon.ktdiscord.interaction.interactionresponse.InteractionCallbackType
import cloud.drakon.ktdiscord.interaction.interactionresponse.interactioncallbackdata.InteractionCallbackData
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@JsExport actual class KtDiscord actual constructor(
    private val publicKey: String,
    private val botToken: String,
    private val applicationId: String?,
) {
    @JsExport.Ignore actual suspend fun createInteractionResponse(
        type: InteractionCallbackType,
        data: InteractionCallbackData,
        interactionId: String,
        interactionToken: String,
    ) = createInteractionResponseSuspend(type, data, interactionId, interactionToken)

    @JsName("createInteractionResponse") fun createInteractionResponseAsync(
        type: InteractionCallbackType,
        data: InteractionCallbackData,
        interactionId: String,
        interactionToken: String,
    ) = GlobalScope.promise {
        createInteractionResponseSuspend(type, data, interactionId, interactionToken)
    }

    @JsExport.Ignore actual suspend fun getOriginalInteractionResponse(
        applicationId: String,
        interactionToken: String,
    ) = getOriginalInteractionResponseSuspend(applicationId, interactionToken)

    @JsName("getOriginalInteractionResponse") fun getOriginalInteractionResponseAsync(
        applicationId: String,
        interactionToken: String,
    ) = GlobalScope.promise {
        getOriginalInteractionResponseSuspend(applicationId, interactionToken)
    }
}
