@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable enum class ChannelType {
    /** A text channel within a server */
    @SerialName("0") GUILD_TEXT,

    /** A voice channel within a server */
    @SerialName("2") GUILD_VOICE,
}
