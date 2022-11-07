package cloud.drakon.tempest.util

enum class Flags(val Flags: Short) {
    /** Do not include any embeds when serializing this message. */
    SUPPRESS_EMBEDS(1 shl 2),

    /** This message is only visible to the user who invoked the Interaction. */
    EPHEMERAL(1 shl 6),
}
