@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.component

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property customId Developer-defined identifier for the input; max 100 characters.
 * @property style The [TextInputStyle].
 * @property label Label for this component; max 45 characters.
 * @property minLength Minimum input length for a text input; min 0, max 4000.
 * @property maxLength Maximum input length for a text input; min 1, max 4000.
 * @property required Whether this component is required to be filled (defaults to `true`).
 * @property value Pre-filled value for this component; max 4000 characters.
 * @property placeholder Custom placeholder text if the input is empty; max 100 characters.
 */
@JsExport @Serializable
class TextInput(
    @SerialName("custom_id") val customId: String,
    val style: TextInputStyle,
    val label: String,
    @SerialName("min_length") val minLength: Short? = null,
    @SerialName("max_length") val maxLength: Short? = null,
    val required: Boolean? = null,
    val value: String? = null,
    val placeholder: String? = null,
) : Component {
    override val type = ComponentType.TEXT_INPUT
}
