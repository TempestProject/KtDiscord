@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property text Footer text.
 * @property iconUrl URL of footer icon (only supports HTTP(S) and attachments).
 * @property proxyIconUrl A proxied URL of footer icon.
 */
@JsExport @Serializable
class EmbedFooter(
    val text: String,
    @SerialName("icon_url") val iconUrl: String,
    @SerialName("proxy_icon_url") val proxyIconUrl: String,
)
