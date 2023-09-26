package cloud.drakon.ktdiscord.channel.embed

import kotlinx.serialization.Serializable

@Serializable class Embed(
    val title: String? = null,
    val type: EmbedType? = null,
    val description: String? = null,
    val url: String? = null,
    val timestamp: String? = null,
    val color: Int? = null,
)
