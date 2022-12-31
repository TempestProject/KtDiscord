package cloud.drakon.ktdiscord.components.selectmenu

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property customId ID for the select menu; max 100 characters
 * @property placeholder Placeholder text if nothing is selected; max 150 characters
 * @property minValues Minimum number of items that must be chosen (defaults to 1); min 0, max 25
 * @property maxValues Maximum number of items that can be chosen (defaults to 1); max 25
 * @property disabled Whether select menu is disabled (defaults to `false`)
 */
@Serializable class UserSelectMenu(
    @SerialName("custom_id") val customId: String,
    val placeholder: String? = null,
    @SerialName("min_values") val minValues: Byte? = null,
    @SerialName("max_values") val maxValues: Byte? = null,
    val disabled: Boolean? = null,
): SelectMenu {
    val type: Byte = 5
}
