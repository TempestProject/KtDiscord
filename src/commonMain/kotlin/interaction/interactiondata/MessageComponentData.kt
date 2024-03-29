package cloud.drakon.ktdiscord.interaction.interactiondata

import cloud.drakon.ktdiscord.components.selectmenu.SelectOption
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property customId the `custom_id` of the components
 * @property componentType the type of the components
 * @property values values the user selected in a select menu components
 */
@Serializable class MessageComponentData(
    @SerialName("custom_id") val customId: String,
    @SerialName("component_type") val componentType: Byte,
    val values: Array<SelectOption>? = null,
): InteractionData
