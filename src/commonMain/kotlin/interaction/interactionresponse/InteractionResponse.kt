package cloud.drakon.ktdiscord.interaction.interactionresponse

import cloud.drakon.ktdiscord.interaction.interactionresponse.interactioncallbackdata.InteractionCallbackData

class InteractionResponse(
    val type: InteractionCallbackType,
    val data: InteractionCallbackData,
)
