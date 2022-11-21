package cloud.drakon.tempest.channel

import kotlinx.serialization.Serializable

/**
 * @property id attachment id
 * @property filename name of file attached
 * @property description description for the file (max 1024 characters)
 * @property content_type the attachment's media type
 * @property size size of file in bytes
 * @property url source url of file
 * @property proxy_url a proxied url of file
 * @property height height of file (if image)
 * @property width width of file (if image)
 * @property ephemeral whether this attachment is ephemeral
 */
@Serializable class Attachment(
    val id: String,
    val filename: String,
    val description: String? = null,
    val content_type: String? = null,
    val size: UInt,
    val url: String,
    val proxy_url: String,
    val height: UInt? = null,
    val width: UInt? = null,
    val ephemeral: Boolean? = null,
)
