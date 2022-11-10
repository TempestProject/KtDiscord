package cloud.drakon.tempest.interaction

import cloud.drakon.tempest.components.Component
import cloud.drakon.tempest.util.Embed

/**
 * @property type Type of response.
 * @property data An optional response message.
 */
class InteractionResponse(
    val type: Enum<InteractionCallbackType>,
    val data: InteractionCallbackData?,
)

enum class InteractionCallbackType(val VALUE: Byte) {
    /** ACK a Ping. */
    PONG(1),

    /** Respond to an interaction with a message. */
    CHANNEL_MESSAGE_WITH_SOURCE(4),

    /** ACK an interaction and edit a response later, the user sees a loading state. */
    DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE(5),

    /** For components, ACK an interaction and edit the original message later; the user does not see a loading state. */
    DEFERRED_UPDATE_MESSAGE(6),

    /** For components, edit the message the component was attached to. */
    UPDATE_MESSAGE(7),

    /** Respond to an autocomplete interaction with suggested choices. */
    APPLICATION_COMMAND_AUTOCOMPLETE_RESULT(8),

    /** Respond to an interaction with a popup modal. */
    MODAL(9)
}

interface InteractionCallbackData

/**
 * @property tts Is the response TTS?
 * @property content Message content.
 * @property embeds Supports up to 10 embeds.
 * @property allowed_mentions Allowed mentions object.
 * @property flags Message flags combined as a bitfield.
 * @property components Message components.
 * @property attachments Attachment objects with filename and description.
 */
class InteractionCallbackDataMessage(
    val tts: Boolean?,
    val content: String?,
    val embeds: Array<Embed>?,
    val allowed_mentions: String?,
    val flags: Short?,
    val components: Array<Component>?,
    val attachments: Array<String>? = TODO(),
): InteractionCallbackData

/**
 * @property choices Autocomplete choices (max of 25 choices).
 */
class InteractionCallbackDataAutocomplete(val choices: Array<String>):
    InteractionCallbackData

/**
 * @property custom_id A developer-defined identifier for the component, max 100 characters.
 * @property title The title of the popup modal, max 45 characters.
 * @property components Between 1 and 5 (inclusive) components that make up the modal.
 */
class InteractionCallbackDataModal(
    val custom_id: String,
    val title: String,
    val components: Array<Component>,
): InteractionCallbackData
