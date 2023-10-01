@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.component

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Components are a framework for adding interactive elements to the messages your app or bot sends. They're accessible, customizable, and easy to use.
 *
 * Components are a field on the [Message] object, so you can use them whether you're sending messages or responding to a slash command or other interaction.
 *
 * The top-level `components` field is an array of [ActionRow] components.
 */
@JsExport
sealed interface Component {
    val type: ComponentType
}
