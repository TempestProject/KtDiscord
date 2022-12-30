package cloud.drakon.discordkt.channel.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property name name of author
 * @property url url of author
 * @property iconUrl url of author icon (only supports http(s) and attachments)
 * @property proxyIconUrl a proxied url of author icon
 */
@Serializable class EmbedAuthor(
    val name: String,
    val url: String? = null,
    @SerialName("icon_url") val iconUrl: String? = null,
    @SerialName("proxy_icon_url") val proxyIconUrl: String? = null,
)
