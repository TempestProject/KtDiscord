package cloud.drakon.ktdiscord.channel

import cloud.drakon.ktdiscord.emoji.Emoji
import kotlinx.serialization.Serializable

/**
 * @property count times this emoji has been used to react
 * @property me whether the current user reacted using this emoji
 * @property emoji emoji information
 */
@Serializable class Reaction(
    val count: Int,
    val me: Boolean,
    val emoji: Emoji,
)
