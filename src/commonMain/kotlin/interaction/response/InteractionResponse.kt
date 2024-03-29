package cloud.drakon.ktdiscord.interaction.response

import cloud.drakon.ktdiscord.interaction.response.interactioncallbackdata.InteractionCallbackData
import kotlinx.serialization.Serializable

/**
 * @property type the type of response
 * @property data an optional response message
 */
@Serializable class InteractionResponse(
    val type: Byte,
    val data: InteractionCallbackData? = null,
)
