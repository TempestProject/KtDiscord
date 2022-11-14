package interaction

import components.selectmenu.SelectOption
import kotlinx.serialization.Serializable

/**
 * @property custom_id the `custom_id` of the components
 * @property component_type the type of the components
 * @property values values the user selected in a select menu components
 */
@Serializable class MessageComponentData(
    val custom_id: String,
    val component_type: Byte,
    val values: Array<SelectOption>? = null,
): InteractionData
