package cloud.drakon.ktdiscord.interaction.component

import kotlinx.serialization.Serializable

@Serializable class ActionRow(val components: Array<Component>): Component {
    override val type: Byte = 1
}
