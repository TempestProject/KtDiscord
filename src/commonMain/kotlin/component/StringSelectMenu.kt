@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.component

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property customId ID for the select menu; max 100 characters.
 * @property options Specified choices in a select menu; max 25.
 * @property placeholder Placeholder text if nothing is selected; max 150 characters.
 * @property minValues Minimum number of items that must be chosen (defaults to 1); min 0, max 25.
 * @property maxValues Maximum number of items that can be chosen (defaults to 1); max 25.
 * @property disabled Whether select menu is disabled (defaults to `false`).
 */
@JsExport @Serializable
data class StringSelectMenu(
    @SerialName("custom_id") val customId: String,
    val options: Array<SelectOption>? = null,
    val placeholder: String? = null,
    @SerialName("min_values") val minValues: Byte? = null,
    @SerialName("max_values") val maxValues: Byte? = null,
    val disabled: Boolean? = null,
) : Component {
    /** Type of select menu component. */
    override val type = ComponentType.STRING_SELECT
}
