package cloud.drakon.tempest.channel.embed

import kotlinx.serialization.Serializable

/**
 * @property url source url of thumbnail (only supports http(s) and attachments)
 * @property proxy_url a proxied url of the thumbnail
 * @property height height of thumbnail
 * @property width width of thumbnail
 */
@Serializable class EmbedThumbnail(
    val url: String,
    val proxy_url: String? = null,
    val height: Short? = null,
    val width: Short? = null,
)
