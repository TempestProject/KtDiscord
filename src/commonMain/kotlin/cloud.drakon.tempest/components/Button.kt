package cloud.drakon.tempest.components

/**
 * Buttons are interactive components that render in messages. They can be clicked by users, and send an interaction to your app when clicked.
 * @property type 2 for a button.
 * @property style A button style.
 * @property label Text that appears on the button; max 80 characters.
 * @property custom_id Developer-defined identifier for the button; max 100 characters.
 * @property url URL for link-style buttons.
 * @property disabled Whether the button is disabled (defaults to false).
 */
class Button(
    val style: ButtonStyle,
    val label: String?,
    val emoji: Emoji?,
    val custom_id: String?,
    val url: String?,
    val disabled: Boolean?
): Component {
    val type: Byte = 2
}

/**
 * Buttons come in a variety of styles to convey different types of actions. These styles also define what fields are valid for a button.
 * - Non-link buttons must have a custom_id, and cannot have a url
 * - Link buttons must have a url, and cannot have a custom_id
 * - Link buttons do not send an interaction to your app when clicked
 */
enum class ButtonStyle(val ButtonStyle: Byte) {
    /**
     * - Name: Primary
     * - Color: Blurple
     * - Required field: custom_id
     */
    PRIMARY(1),
    /**
     * - Name: Secondary
     * - Color: Grey
     * - Required field: custom_id
     */
    SECONDARY(2),
    /**
     * - Name: Success
     * - Color: Green
     * - Required field: custom_id
     */
    SUCCESS(3),
    /**
     * - Name: Danger
     * - Color: Red
     * - Required field: custom_id
     */
    DANGER(4),
    /**
     * - Name: Link
     * - Color: Grey, navigates to a URL
     * - Required field: url
     */
    LINK(5),
}
