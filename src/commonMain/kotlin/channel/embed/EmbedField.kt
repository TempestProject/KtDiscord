package cloud.drakon.ktdiscord.channel.embed

import kotlinx.serialization.Serializable

@Serializable class EmbedField(
    val name: String,
    val value: String,
    val inline: Boolean? = null,
)
