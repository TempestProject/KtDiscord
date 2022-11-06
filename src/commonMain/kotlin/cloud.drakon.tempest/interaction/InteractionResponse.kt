package cloud.drakon.tempest.interaction

import cloud.drakon.tempest.util.Embed

class InteractionResponse(type: InteractionCallbackType, data: InteractionCallbackData?)

enum class InteractionCallbackType(val InteractionCallbackType: Byte) {
    PONG(1),
    CHANNEL_MESSAGE_WITH_SOURCE(4),
    DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE(5),
    DEFERRED_UPDATE_MESSAGE(6),
    UPDATE_MESSAGE(7),
    APPLICATION_COMMAND_AUTOCOMPLETE_RESULT(8),
    MODAL(9)
}

interface InteractionCallbackData

class InteractionCallbackDataMessage(
    val tts: Boolean?,
    val content: String?,
    val embeds: Array<Embed>?,
    val allowed_mentions: String?,
    val flags: Short?,
    val components: Array<String>?,
    val attachments: Array<String>?
) : InteractionCallbackData

class InteractionCallbackDataAutocomplete(val choices: Array<String>) : InteractionCallbackData

class InteractionCallbackDataModal(val custom_id: String, val title: String, val components: Array<String>) :
    InteractionCallbackData
