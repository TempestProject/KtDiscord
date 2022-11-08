package cloud.drakon.tempest.components.selectmenu

import cloud.drakon.tempest.components.Component

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
    val type: SelectMenuType,
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
