package cloud.drakon.ktdiscord.channel.embed

import kotlinx.serialization.Serializable

@Serializable class EmbedProvider(
    val name: String? = null,
    val url: String? = null,
)
