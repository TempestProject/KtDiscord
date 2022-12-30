package cloud.drakon.discordkt.components.selectmenu

import cloud.drakon.discordkt.components.Component

/**
 * Select menus are interactive components that allow users to select one or more options from a dropdown list in messages. On desktop, clicking on a select menu opens a dropdown-style UI; on mobile, tapping a select menu opens up a half-sheet with the options.
 *
 * Select menus support single-select and multi-select behavior, meaning you can prompt a user to choose just one item from a list, or multiple. When a user finishes making their choice(s) by clicking out of the dropdown or closing the half-sheet, your app will receive an interaction.
 * - Select menus must be sent inside an Action Row
 * - An Action Row can contain only one select menu
 * - An Action Row containing a select menu cannot also contain buttons
 */
interface SelectMenu: Component
