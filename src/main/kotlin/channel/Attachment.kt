package cloud.drakon.discordkt.channel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property id attachment id
 * @property filename name of file attached
 * @property description description for the file (max 1024 characters)
 * @property contentType the attachment's media type
 * @property size size of file in bytes
 * @property url source url of file
 * @property proxyUrl a proxied url of file
 * @property height height of file (if image)
 * @property width width of file (if image)
 * @property ephemeral whether this attachment is ephemeral
 */
@Serializable class Attachment(
    val id: String,
    val filename: String,
    val description: String? = null,
    @SerialName("content_type") val contentType: String? = null,
    val size: UInt? = null,
    val url: String? = null,
    @SerialName("proxy_url") val proxyUrl: String? = null,
    val height: Short? = null,
    val width: Short? = null,
    val ephemeral: Boolean? = null,
)
