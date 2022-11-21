package cloud.drakon.tempest.channel.embed

import kotlinx.serialization.Serializable

/**
 * @property text footer text
 * @property icon_url url of footer icon (only supports http(s) and attachments)
 * @property proxy_icon_url a proxied url of footer icon
 */
@Serializable class EmbedFooter(
    val text: String,
    val icon_url: String? = null,
    val proxy_icon_url: String? = null,
)
