package cloud.drakon.ktdiscord.channel.embed

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property url source url of thumbnail (only supports http(s) and attachments)
 * @property proxyUrl a proxied url of the thumbnail
 * @property height height of thumbnail
 * @property width width of thumbnail
 */
@JsExport @Serializable class EmbedThumbnail(
    val url: String,
    @SerialName("proxy_url") val proxyUrl: String? = null,
    val height: Short? = null,
    val width: Short? = null,
)
