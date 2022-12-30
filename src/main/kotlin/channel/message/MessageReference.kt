package cloud.drakon.discordkt.channel.message

import kotlinx.serialization.Serializable

/**
 * @property message_id id of the originating message
 * @property channel_id id of the originating message's channel
 * @property guild_id id of the originating message's guild
 * @property fail_if_not_exists when sending, whether to error if the referenced message doesn't exist instead of sending as a normal (non-reply) message, default true
 */
@Serializable class MessageReference(
    val message_id: String? = null,
    val channel_id: String? = null,
    val guild_id: String? = null,
    val fail_if_not_exists: String? = null,
)
