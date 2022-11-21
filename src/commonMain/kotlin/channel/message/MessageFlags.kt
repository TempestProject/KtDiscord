package cloud.drakon.tempest.channel.message

object MessageFlags {
    const val SUPPRESS_EMBEDS: Byte = 1 shl 2
    const val EPHEMERAL: Byte = 1 shl 6
}
