@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.component.textinput

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable enum class TextInputStyle {
    /** Single-line input */
    @SerialName("1") SHORT,

    /** Multi-line input */
    @SerialName("2") PARAGRAPH
}
