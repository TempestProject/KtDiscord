package cloud.drakon.tempest.components

import cloud.drakon.tempest.channel.ChannelType
import cloud.drakon.tempest.emoji.Emoji

/**
 * Select menus are interactive components that allow users to select one or more options from a dropdown list in messages. On desktop, clicking on a select menu opens a dropdown-style UI; on mobile, tapping a select menu opens up a half-sheet with the options.
 *
 * Select menus support single-select and multi-select behavior, meaning you can prompt a user to choose just one item from a list, or multiple. When a user finishes making their choice(s) by clicking out of the dropdown or closing the half-sheet, your app will receive an interaction.
 * - Select menus must be sent inside an Action Row
 * - An Action Row can contain only one select menu
 * - An Action Row containing a select menu cannot also contain buttons
 * @property type Type of select menu component (user: 5, role: 6, mentionable: 7).
 * @property custom_id ID for the select menu; max 100 characters.
 * @property placeholder Placeholder text if nothing is selected; max 150 characters.
 * @property min_values Minimum number of items that must be chosen (defaults to 1); min 0, max 25.
 * @property max_values Maximum number of items that can be chosen (defaults to 1); max 25.
 * @property disabled Whether select menu is disabled (defaults to false).
 */
class SelectMenu(
    val type: Enum<SelectMenuType>,
    val custom_id: String,
    val placeholder: String?,
    val min_values: Byte?,
    val max_values: Byte?,
    val disabled: Boolean?,
): Component

/** Type of select menu component. */
enum class SelectMenuType(val TYPE: Byte) {
    /** Select menu for users. */
    USER(5),

    /** Select menu for roles. */
    ROLE(6),

    /** Select menu for mentionables (users and roles). */
    MENTIONABLE(7)
}

/**
 * Select menu for channels.
 * @property type Type of select menu component.
 * @property custom_id ID for the select menu; max 100 characters.
 * @property channel_types List of channel types to include in the channel select component.
 * @property placeholder Placeholder text if nothing is selected; max 150 characters.
 * @property min_values Minimum number of items that must be chosen (defaults to 1); min 0, max 25.
 * @property max_values Number of items that can be chosen (defaults to 1); max 25.
 * @property disabled Whether select menu is disabled (defaults to false).
 */
class ChannelSelectMenu(
    val custom_id: String,
    val channel_types: Array<Enum<ChannelType>>,
    val placeholder: String?,
    val min_values: Byte?,
    val max_values: Byte?,
    val disabled: Boolean?,
): Component {
    val type: Byte = 8
}

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
    val disabled: Boolean?,
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
    val default: Boolean?,
)
