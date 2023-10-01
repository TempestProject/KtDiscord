@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.attachment

import cloud.drakon.ktdiscord.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property id Attachment ID.
 * @property filename Name of file attached.
 * @property description Description for the file (max 1024 characters).
 * @property contentType The attachment's [media type](https://en.wikipedia.org/wiki/Media_type).
 * @property size Size of file in bytes.
 * @property url Source URL of file.
 * @property proxyUrl Proxied URL of file.
 * @property height Height of file (if image).
 * @property width Width of file (if image).
 * @property ephemeral Whether this attachment is ephemeral.
 * @property durationSecs The duration of the audio file (currently for voice messages).
 * @property waveform Base64 encoded bytearray representing a sampled waveform (currently for voice messages).
 * @property flags [AttachmentFlags] combined as a [bitfield](https://en.wikipedia.org/wiki/Bit_field).
 */
@JsExport @Serializable
data class Attachment(
    val id: Snowflake,
    val filename: String,
    val description: String? = null,
    @SerialName("content_type") val contentType: String? = null,
    val size: Int,
    val url: String,
    @SerialName("proxy_url") val proxyUrl: String,
    val height: Int? = null,
    val width: Int? = null,
    val ephemeral: Boolean? = null,
    @SerialName("duration_secs") val durationSecs: Double? = null,
    val waveform: String? = null,
    val flags: Int? = null,
)
