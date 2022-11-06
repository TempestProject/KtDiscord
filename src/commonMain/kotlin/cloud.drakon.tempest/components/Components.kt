package cloud.drakon.tempest.components

class Components(val type: Short, val components: Array<Component>)

enum class ComponentTypes(val ComponentTypes: Byte) {
    ACTION_ROW(1),
    BUTTON(2),
    STRING_SELECT(3),
    TEXT_INPUT(4),
    USER_SELECT(5),
    ROLE_SELECT(6),
    MENTIONABLE_SELECT(7),
    CHANNEL_SELECT(8)
}

interface Component

class ActionRow(val components: Array<Component>) : Component {
    val type: Byte = 1
}
