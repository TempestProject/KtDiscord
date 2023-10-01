@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property url Source URL.
 * @property proxyUrl A proxied URL.
 * @property height Height.
 * @property width Width.
 */
@JsExport @Serializable
class GenericEmbed(
    val url: String,
    @SerialName("proxy_url") val proxyUrl: String? = null,
    val height: Int? = null,
    val width: Int? = null,
)

typealias EmbedThumbnail = GenericEmbed
typealias EmbedVideo = GenericEmbed
typealias EmbedImage = GenericEmbed
