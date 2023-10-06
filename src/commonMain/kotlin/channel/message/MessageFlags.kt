@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.message

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport
object MessageFlags {
    /** This message has been published to subscribed channels (via Channel Following). */
    const val CROSSPOSTED = 1 shl 0

    /** This message originated from a message in another channel (via Channel Following). */
    const val IS_CROSSPOST = 1 shl 1

    /** Do not include any embeds when serializing this message. */
    const val SUPPRESS_EMBEDS = 1 shl 2

    /** The source message for this crosspost has been deleted (via Channel Following). */
    const val SOURCE_MESSAGE_DELETED = 1 shl 3

    /** This message came from the urgent message system. */
    const val URGENT = 1 shl 4

    /** This message has an associated thread, with the same id as the message. */
    const val HAS_THREAD = 1 shl 5

    /** This message is only visible to the user who invoked the [Interaction]. */
    const val EPHEMERAL = 1 shl 6

    /** This message is an [InteractionResponse] and the bot is "thinking". */
    const val LOADING = 1 shl 7

    /** This message failed to mention some roles and add their members to the thread. */
    const val FAILED_TO_MENTION_SOME_ROLES_IN_THREAD = 1 shl 8

    /** This message will not trigger push and desktop notifications. */
    const val SUPPRESS_NOTIFICATIONS = 1 shl 12

    /** This message is a voice message. */
    const val IS_VOICE_MESSAGE = 1 shl 13
}
