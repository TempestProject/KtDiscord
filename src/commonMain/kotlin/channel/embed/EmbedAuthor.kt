@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property name Name of author.
 * @property url URL of author (only supports HTTP(S)).
 * @property iconUrl URL of author icon (only supports HTTP(S) and attachments).
 * @property proxyIconUrl A proxied URL of author icon.
 */
@JsExport @Serializable
class EmbedAuthor(
    val name: String,
    val url: String? = null,
    @SerialName("icon_url") val iconUrl: String? = null,
    @SerialName("proxy_icon_url") val proxyIconUrl: String? = null,
)
