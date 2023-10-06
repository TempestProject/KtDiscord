@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class InteractionCallbackType {
    /** ACK a `Ping`. */
    @SerialName("1") PONG,

    /** Respond to an interaction with a message. */
    @SerialName("4") CHANNEL_MESSAGE_WITH_SOURCE,

    /** ACK an interaction and edit a response later, the user sees a loading state. */
    @SerialName("5") DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE,

    /** For components, ACK an interaction and edit the original message later; the user does not see a loading state. */
    @SerialName("6") DEFERRED_UPDATE_MESSAGE,

    /** For components, edit the message the component was attached to. */
    @SerialName("7") UPDATE_MESSAGE,

    /** Respond to an autocomplete interaction with suggested choices. */
    @SerialName("8") APPLICATION_COMMAND_AUTOCOMPLETE_RESULT,

    /** Respond to an interaction with a popup modal. */
    @SerialName("9") MODAL,
}
