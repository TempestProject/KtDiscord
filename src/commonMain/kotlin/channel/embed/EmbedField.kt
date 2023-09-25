@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.embed

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable class EmbedField(
    val name: String,
    val value: String,
    val inline: Boolean? = null,
)
