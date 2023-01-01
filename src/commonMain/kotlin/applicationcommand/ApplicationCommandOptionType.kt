package cloud.drakon.ktdiscord.applicationcommand

import kotlin.js.JsExport

@JsExport object ApplicationCommandOptionType {
    const val SUB_COMMAND: Byte = 1
    const val SUB_COMMAND_GROUP: Byte = 2
    const val STRING: Byte = 3

    /** Any integer between -2^53 and 2^53 */
    const val INTEGER: Byte = 4
    const val BOOLEAN: Byte = 5
    const val USER: Byte = 6

    /** Includes all channel types + categories */
    const val CHANNEL: Byte = 7
    const val ROLE: Byte = 8

    /** Includes users and roles */
    const val MENTIONABLE: Byte = 9

    /** Any double between -2^53 and 2^53 */
    const val NUMBER: Byte = 10
    const val ATTACHMENT: Byte = 11
}
