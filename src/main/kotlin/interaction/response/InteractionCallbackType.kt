package cloud.drakon.tempest.interaction.response

object InteractionCallbackType {
    /** ACK a `Ping` */
    const val PONG: Byte = 1

    /** respond to an interaction with a message */
    const val CHANNEL_MESSAGE_WITH_SOURCE: Byte = 4

    /** ACK an interaction and edit a response later, the user sees a loading state */
    const val DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE: Byte = 5

    /** for components, ACK an interaction and edit the original message later; the user does not see a loading state. */
    const val DEFERRED_UPDATE_MESSAGE: Byte = 6

    /** for components, edit the message the component was attached to */
    const val UPDATE_MESSAGE: Byte = 7

    /** respond to an autocomplete interaction with suggested choices */
    const val APPLICATION_COMMAND_AUTOCOMPLETE_RESULT: Byte = 8

    /** respond to an interaction with a popup modal */
    const val MODAL: Byte = 9
}
