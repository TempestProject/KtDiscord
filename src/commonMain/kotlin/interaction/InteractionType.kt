@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class InteractionType {
    @SerialName("1") PING,
    @SerialName("2") APPLICATION_COMMAND,
    @SerialName("3") MESSAGE_COMPONENT,
    @SerialName("4") APPLICATION_COMMAND_AUTOCOMPLETE,
    @SerialName("5") MODAL_SUBMIT,
}
