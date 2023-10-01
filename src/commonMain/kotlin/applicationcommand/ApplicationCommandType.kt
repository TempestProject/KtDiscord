@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.applicationcommand

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class ApplicationCommandType {
    /** Slash commands; a text-based command that shows up when a user types. */
    @SerialName("1") CHAT_INPUT,

    /** A UI-based command that shows up when you right click or tap on a user. */
    @SerialName("2") USER,

    /** A UI-based command that shows up when you right click or tap on a message. */
    @SerialName("3") MESSAGE,
}
