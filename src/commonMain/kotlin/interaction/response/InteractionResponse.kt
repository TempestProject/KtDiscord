package interaction.response

import interaction.response.interactioncallbackdata.InteractionCallbackData
import kotlinx.serialization.Serializable

/**
 * @property type the type of response
 * @property data an optional response message
 */
@Serializable class InteractionResponse(
    val type: Byte,
    val data: InteractionCallbackData? = null,
)
