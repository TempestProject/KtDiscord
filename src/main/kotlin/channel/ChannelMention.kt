package cloud.drakon.discordkt.channel

import kotlinx.serialization.Serializable

/**
 * @property id id of the channel
 * @property guild_id id of the guild containing the channel
 * @property type the type of channel
 * @property name the name of the channel
 */
@Serializable class ChannelMention(
    val id: String,
    val guild_id: String,
    val type: Byte,
    val name: String,
)
