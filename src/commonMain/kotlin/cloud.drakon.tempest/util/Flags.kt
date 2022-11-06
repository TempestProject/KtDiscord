package cloud.drakon.tempest.util

enum class Flags(val Flags: Short) {
    SUPPRESS_EMBEDS(1 shl 2),
    EPHEMERAL(1 shl 6),
}
