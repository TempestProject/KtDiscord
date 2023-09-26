package cloud.drakon.ktdiscord.interaction.component.selectmenu

import kotlinx.serialization.Serializable

@Serializable class SelectDefaultValue(
    val id: String,
    val type: SelectDefaultValueType,
)
