@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.component

import cloud.drakon.ktdiscord.channel.ChannelType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property customId ID for the select menu; max 100 characters.
 * @property channelTypes List of channel types to include in the channel select component.
 * @property placeholder Placeholder text if nothing is selected; max 150 characters.
 * @property defaultValues List of default values for auto-populated select menu components; number of default values must be in the range defined by [minValues] and [maxValues].
 * @property minValues Minimum number of items that must be chosen (defaults to 1); min 0, max 25.
 * @property maxValues Maximum number of items that can be chosen (defaults to 1); max 25.
 * @property disabled Whether select menu is disabled (defaults to `false`).
 */
@JsExport @Serializable
class ChannelSelectMenu(
    @SerialName("custom_id") val customId: String,
    @SerialName("channel_types") val channelTypes: Array<ChannelType>? = null,
    val placeholder: String? = null,
    @SerialName("default_values") val defaultValues: Array<SelectDefaultValue>? = null,
    @SerialName("min_values") val minValues: Byte? = null,
    @SerialName("max_values") val maxValues: Byte? = null,
    val disabled: Boolean? = null,
) : Component {
    /** Type of select menu component. */
    override val type = ComponentType.CHANNEL_SELECT
}
