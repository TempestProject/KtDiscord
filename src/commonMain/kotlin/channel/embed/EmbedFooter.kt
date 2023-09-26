package cloud.drakon.ktdiscord.channel.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable class EmbedFooter(
    val text: String,
    @SerialName("icon_url") val iconUrl: String? = null,
    @SerialName("proxy_icon_url") val proxyIconUrl: String? = null,
)
