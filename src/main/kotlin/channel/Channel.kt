package cloud.drakon.discordkt.channel

import kotlinx.serialization.Serializable

/**
 * @property id the id of this channel
 * @property type the type of channel
 * @property guild_id the id of the guild
 * @property position sorting position of the channel
 */
@Serializable class Channel(
    val id: String,
    val type: Byte,
    val guild_id: String? = null,
    val position: UInt? = null,
    val permission_overwrites: Array<Overwrite>? = null,
    val name: String? = null,
)
