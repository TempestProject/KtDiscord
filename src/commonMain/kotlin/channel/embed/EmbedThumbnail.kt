@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.embed

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable class EmbedThumbnail(
    val url: String,
    @SerialName("proxy_url") val proxyUrl: String? = null,
    val height: Int? = null,
    val width: Int? = null,
)
