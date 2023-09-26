package cloud.drakon.ktdiscord.channel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable enum class MessageFlags {
    @SerialName((1 shl 2).toString()) SUPPRESS_EMBEDS,
    @SerialName((1 shl 6).toString()) EPHEMERAL
}
