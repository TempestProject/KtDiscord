package cloud.drakon.discordkt.channel.embed

import kotlinx.serialization.Serializable

/**
 * @property name name of author
 * @property url url of author
 * @property icon_url url of author icon (only supports http(s) and attachments)
 * @property proxy_icon_url a proxied url of author icon
 */
@Serializable class EmbedAuthor(
    val name: String,
    val url: String? = null,
    val icon_url: String? = null,
    val proxy_icon_url: String? = null,
)
