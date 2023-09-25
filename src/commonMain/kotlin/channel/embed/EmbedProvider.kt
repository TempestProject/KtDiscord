@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.embed

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable class EmbedProvider(
    val name: String? = null,
    val url: String? = null,
)
