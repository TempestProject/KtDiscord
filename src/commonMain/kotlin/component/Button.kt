@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.component

import cloud.drakon.ktdiscord.emoji.Emoji
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Buttons are interactive components that render in messages. They can be clicked by users, and send an [Interaction] to your app when clicked.
 *
 * * Buttons must be sent inside an Action Row.
 * * An Action Row can contain up to 5 buttons.
 * * An Action Row containing buttons cannot also contain any select menu components.
 */
@JsExport @Serializable
class Button(
    val style: ButtonStyle,
    val label: String? = null,
    val emoji: Emoji? = null,
) : Component {
    override val type = ComponentType.BUTTON
}
