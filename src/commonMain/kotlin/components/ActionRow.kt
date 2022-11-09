package cloud.drakon.tempest.components

/**
 * An Action Row is a non-interactive container component for other types of components. It has a sub-array of components of other types.
 * - You can have up to 5 Action Rows per message
 * - An Action Row cannot contain another Action Row
 */
class ActionRow(val components: Array<Component>): Component {
    val type: Byte = 1
}
