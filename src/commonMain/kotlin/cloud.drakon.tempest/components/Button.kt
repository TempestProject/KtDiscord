package cloud.drakon.tempest.components

class Button(
    val style: ButtonStyle,
    val label: String?,
    val emoji: Emoji?,
    val custom_id: String?,
    val url: String?,
    disabled: Boolean?
) : Component {
    val type: Byte = 2
}

enum class ButtonStyle(val ButtonStyle: Byte) {
    PRIMARY(1),
    SECONDARY(2),
    SUCCESS(3),
    DANGER(4),
    LINK(5),
}
