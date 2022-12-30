package cloud.drakon.ktdiscord.components.textinput

import cloud.drakon.ktdiscord.components.Component
import kotlinx.serialization.SerialName

/**
 * @property customId Developer-defined identifier for the input; max 100 characters
 * @property style The Text Input Style
 * @property label Label for this component; max 45 characters
 * @property minLength Minimum input length for a text input; min 0, max 4000
 * @property maxLength Maximum input length for a text input; min 1, max 4000
 * @property required Whether this component is required to be filled (defaults to `true`)
 * @property value Pre-filled value for this component; max 4000 characters
 * @property placeholder Custom placeholder text if the input is empty; max 100 characters
 */
class TextInput(
    @SerialName("custom_id") val customId: String,
    val style: Byte,
    val label: String,
    @SerialName("min_length") val minLength: Byte? = null,
    @SerialName("max_length") val maxLength: Byte? = null,
    val required: Boolean? = null,
    val value: String? = null,
    val placeholder: String? = null,
): Component {
    val type: Byte = 4
}
