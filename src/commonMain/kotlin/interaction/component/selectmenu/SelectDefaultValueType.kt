package cloud.drakon.ktdiscord.interaction.component.selectmenu

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable enum class SelectDefaultValueType {
    @SerialName("user") USER, @SerialName("role") ROLE, @SerialName("channel") CHANNEL
}
