@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.embed

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable class EmbedFooter(
    val text: String,
    @SerialName("icon_url") val iconUrl: String? = null,
    @SerialName("proxy_icon_url") val proxyIconUrl: String? = null,
)
