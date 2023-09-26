@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.emoji

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable class Emoji(
    val id: String,
    val name: String,
    val animated: Boolean? = null,
)
