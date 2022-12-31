package cloud.drakon.ktdiscord.channel.message

import kotlin.js.JsExport

@JsExport object MessageFlags {
    const val SUPPRESS_EMBEDS: Byte = 1 shl 2
    const val EPHEMERAL: Byte = 1 shl 6
}
