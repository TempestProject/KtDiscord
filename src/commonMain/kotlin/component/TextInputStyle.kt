@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.component

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class TextInputStyle {
    /** Single-line input. */
    @SerialName("1") SHORT,

    /** Multi-line input. */
    @SerialName("2") PARAGRAPH
}
