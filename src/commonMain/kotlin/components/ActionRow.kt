package cloud.drakon.ktdiscord.components

import kotlinx.serialization.Serializable

/**
 * An Action Row is a non-interactive container component for other types of components. It has a sub-array of `components` of other types.
 * - You can have up to 5 Action Rows per message
 * - An Action Row cannot contain another Action Row
 */
@Serializable class ActionRow(val components: Array<Component>): Component {
    val type: Byte = 1
}
