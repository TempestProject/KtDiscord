package cloud.drakon.ktdiscord.channel.embed

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property url source url of video
 * @property proxyUrl a proxied url of the video
 * @property height height of video
 * @property width width of video
 */
@JsExport @Serializable class EmbedVideo(
    val url: String,
    @SerialName("proxy_url") val proxyUrl: String? = null,
    val height: Short? = null,
    val width: Short? = null,
)
