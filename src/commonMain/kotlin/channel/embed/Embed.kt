@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.embed

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable class Embed(
    val title: String? = null,
    val type: EmbedType? = null,
    val description: String? = null,
    val url: String? = null,
    val timestamp: String? = null,
    val color: Int? = null,
)
