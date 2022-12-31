package cloud.drakon.ktdiscord.channel.embed

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property text footer text
 * @property iconUrl url of footer icon (only supports http(s) and attachments)
 * @property proxyIconUrl a proxied url of footer icon
 */
@JsExport @Serializable class EmbedFooter(
    val text: String,
    @SerialName("icon_url") val iconUrl: String? = null,
    @SerialName("proxy_icon_url") val proxyIconUrl: String? = null,
)
