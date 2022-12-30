package cloud.drakon.discordkt.components.selectmenu

/**
 * @property custom_id ID for the select menu; max 100 characters
 * @property channel_types List of channel types to include in the channel select component
 * @property placeholder Placeholder text if nothing is selected; max 150 characters
 * @property min_values Minimum number of items that must be chosen (defaults to 1); min 0, max 25
 * @property max_values Maximum number of items that can be chosen (defaults to 1); max 25
 * @property disabled Whether select menu is disabled (defaults to `false`)
 */
class ChannelSelectMenu(
    val custom_id: String,
    val channel_types: ByteArray? = null,
    val placeholder: String? = null,
    val min_values: Byte? = null,
    val max_values: Byte? = null,
    val disabled: Boolean? = null,
): SelectMenu {
    val type: Byte = 8
}
