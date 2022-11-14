package components.textinput

import components.Component

/**
 * @property custom_id Developer-defined identifier for the input; max 100 characters
 * @property style The Text Input Style
 * @property label Label for this component; max 45 characters
 * @property min_length Minimum input length for a text input; min 0, max 4000
 * @property max_length Maximum input length for a text input; min 1, max 4000
 * @property required Whether this component is required to be filled (defaults to `true`)
 * @property value Pre-filled value for this component; max 4000 characters
 * @property placeholder Custom placeholder text if the input is empty; max 100 characters
 */
class TextInput(
    val custom_id: String,
    val style: Byte,
    val label: String,
    val min_length: Byte? = null,
    val max_length: Byte? = null,
    val required: Boolean? = null,
    val value: String? = null,
    val placeholder: String? = null,
): Component {
    val type: Byte = 4
}
