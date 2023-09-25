package cloud.drakon.ktdiscord.interaction.interactionresponse

enum class InteractionCallbackType {
    PONG,
    CHANNEL_MESSAGE_WITH_SOURCE,
    DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE,
    DEFERRED_UPDATE_MESSAGE,
    UPDATE_MESSAGE,
    APPLICATION_COMMAND_AUTOCOMPLETE_RESULT,
    MODAL
}
