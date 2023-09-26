@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable class Attachment(
    val filename: String,
    val description: String? = null,
)
