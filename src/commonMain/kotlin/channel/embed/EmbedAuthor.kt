package cloud.drakon.ktdiscord.channel.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable class EmbedAuthor(
    val url: String,
    @SerialName("proxy_url") val proxyUrl: String? = null,
    val height: Int? = null,
    val width: Int? = null,
)
