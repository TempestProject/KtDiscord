package cloud.drakon.tempest.components.selectmenu

import cloud.drakon.tempest.components.Component
import cloud.drakon.tempest.components.Emoji

/**
 * Select menu for picking from defined text options.
 * @property type Type of select menu component.
 * @property custom_id ID for the select menu; max 100 characters.
 * @property options Specified choices in a select menu; max 25.
 * @property placeholder Placeholder text if nothing is selected; max 150 characters.
 * @property min_values Minimum number of items that must be chosen (defaults to 1); min 0, max 25.
 * @property max_values Maximum number of items that can be chosen (defaults to 1); max 25.
 * @property disabled Whether select menu is disabled (defaults to false).
 */
class TextSelectMenu(
    val custom_id: String,
    val options: Array<SelectOption>,
    val placeholder: String?,
    val min_values: Byte?,
    val max_values: Byte?,
    val disabled: Boolean?
): Component {
    val type: Byte = 3
}

/**
 * Specified choices in a select menu (only required and available for string selects); max 25.
 * @property label User-facing name of the option; max 100 characters.
 * @property value Dev-defined value of the option; max 100 characters.
 * @property description Additional description of the option; max 100 characters.
 * @property default Will show this option as selected by default.
 */
class SelectOption(
    val label: String,
    val value: String,
    val description: String?,
    val emoji: Emoji?,
    val default: Boolean?
)
