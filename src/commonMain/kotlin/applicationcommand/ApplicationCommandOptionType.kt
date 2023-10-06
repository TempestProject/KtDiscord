@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.applicationcommand

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class ApplicationCommandOptionType {
    @SerialName("1") SUB_COMMAND,
    @SerialName("2") SUB_COMMAND_GROUP,
    @SerialName("3") STRING,

    /** Any integer between -2^53 and 2^53. */
    @SerialName("4") INTEGER,

    @SerialName("5") BOOLEAN,
    @SerialName("6") USER,

    /** Includes all channel types + categories. */
    @SerialName("7") CHANNEL,

    @SerialName("8") ROLE,

    /** Includes users and roles. */
    @SerialName("9") MENTIONABLE,

    /** Any double between -2^53 and 2^53. */
    @SerialName("10") NUMBER,

    /** [Attachment] object. */
    @SerialName("11") ATTACHMENT,
}
