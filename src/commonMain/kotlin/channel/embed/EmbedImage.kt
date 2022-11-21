package cloud.drakon.tempest.channel.embed

import kotlinx.serialization.Serializable

/**
 * @property url source url of image (only supports http(s) and attachments)
 * @property proxy_url a proxied url of the image
 * @property height height of image
 * @property width width of image
 */
@Serializable class EmbedImage(
    val url: String,
    val proxy_url: String? = null,
    val height: UInt? = null,
    val width: UInt? = null,
)
