package cloud.drakon.ktdiscord.channel.embed

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property url source url of image (only supports http(s) and attachments)
 * @property proxyUrl a proxied url of the image
 * @property height height of image
 * @property width width of image
 */
@JsExport @Serializable class EmbedImage(
    val url: String,
    @SerialName("proxy_url") val proxyUrl: String? = null,
    val height: Short? = null,
    val width: Short? = null,
)
