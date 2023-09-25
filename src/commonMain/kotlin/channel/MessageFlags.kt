package cloud.drakon.ktdiscord.channel

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable enum class MessageFlags {
    @SerialName((1 shl 2).toString()) SUPPRESS_EMBEDS,
    @SerialName((1 shl 6).toString()) EPHEMERAL
}
