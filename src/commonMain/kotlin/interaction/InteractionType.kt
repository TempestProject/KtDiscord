package cloud.drakon.tempest.interaction

object InteractionType {
    const val PING: Byte = 1
    const val APPLICATION_COMMAND: Byte = 2
    const val MESSAGE_COMPONENT: Byte = 3
    const val APPLICATION_COMMAND_AUTOCOMPLETE: Byte = 4
    const val MODAL_SUBMIT: Byte = 5
}
