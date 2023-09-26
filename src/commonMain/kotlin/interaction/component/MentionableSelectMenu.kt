package cloud.drakon.ktdiscord.interaction.component

import cloud.drakon.ktdiscord.interaction.component.selectmenu.SelectDefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable class MentionableSelectMenu(
    @SerialName("custom_id") val customId: String? = null,
    val placeholder: String? = null,
    val defaultValues: Array<SelectDefaultValue>,
    @SerialName("min_values") val minValues: Byte? = null,
    @SerialName("max_values") val maxValues: Byte? = null,
    val disabled: Boolean? = null,
): Component {
    override val type: Byte = 7
}
