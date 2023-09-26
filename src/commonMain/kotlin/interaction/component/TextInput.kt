package cloud.drakon.ktdiscord.interaction.component

import cloud.drakon.ktdiscord.interaction.component.textinput.TextInputStyle
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable class TextInput(
    @SerialName("custom_id") val customId: String,
    val style: TextInputStyle,
    val label: String,
    @SerialName("min_length") val minLength: Short? = null,
    @SerialName("max_length") val maxLength: Short? = null,
    val required: Boolean? = null,
    val value: String? = null,
    val placeholder: String? = null,
): Component {
    override val type: Byte = 4
}
