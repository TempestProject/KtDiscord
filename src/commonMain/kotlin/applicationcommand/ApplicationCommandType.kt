package cloud.drakon.ktdiscord.applicationcommand

import kotlin.js.JsExport

@JsExport object ApplicationCommandType {
    const val CHAT_INPUT: Byte = 1
    const val USER: Byte = 2
    const val MESSAGE: Byte = 3
}
