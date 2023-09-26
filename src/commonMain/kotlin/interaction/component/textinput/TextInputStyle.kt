package cloud.drakon.ktdiscord.interaction.component.textinput

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable enum class TextInputStyle {
    /** Single-line input */
    @SerialName("1") SHORT,

    /** Multi-line input */
    @SerialName("2") PARAGRAPH
}
