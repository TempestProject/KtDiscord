package components.button

import components.Component
import emoji.Emoji

/**
 * Buttons are interactive components that render in messages. They can be clicked by users, and send an interaction to your app when clicked.
 * - Buttons must be sent inside an Action Row
 * - An Action Row can contain up to 5 buttons
 * - An Action Row containing buttons cannot also contain any select menu components
 */
class Button(
    val style: Byte,
    val label: String? = null,
    val emoji: Emoji? = null,
    val custom_id: String? = null,
    val url: String? = null,
    val disabled: Boolean? = null,
): Component {
    val type: Byte = 2
}
