@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class MessageType {
    @SerialName("0") DEFAULT
}
