package cloud.drakon.tempest.channel

import cloud.drakon.tempest.emoji.Emoji
import kotlinx.serialization.Serializable

/**
 * @property count times this emoji has been used to react
 * @property me whether the current user reacted using this emoji
 * @property emoji emoji information
 */
@Serializable class Reaction(
    val count: UInt,
    val me: Boolean,
    val emoji: Emoji,
    val burst_colors: Array<String>?, //TODO undocumented,
    val burst_count: Byte?, //TODO undocumented
    val burst_me: Boolean?, //TODO undocumented
    val burst_user_ids: Array<String>?, //TODO undocumented
)
