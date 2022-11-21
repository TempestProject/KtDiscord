package cloud.drakon.tempest.channel.embed

import kotlinx.serialization.Serializable

/**
 * @property url source url of video
 * @property proxy_url a proxied url of the video
 * @property height height of video
 * @property width width of video
 */
@Serializable class EmbedVideo(
    val url: String,
    val proxy_url: String? = null,
    val height: UInt? = null,
    val width: UInt? = null,
)
