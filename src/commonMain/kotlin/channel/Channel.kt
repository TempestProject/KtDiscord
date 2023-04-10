package cloud.drakon.ktdiscord.channel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property id the id of this channel
 * @property type the type of channel
 * @property guildId the id of the guild
 * @property position sorting position of the channel
 */
@Serializable class Channel(
    val id: String,
    val type: Byte,
    @SerialName("guild_id") val guildId: String? = null,
    val position: Int? = null,
    @SerialName("permission_overwrites")
    val permissionOverwrites: Array<Overwrite>? = null,
    val name: String? = null,
)
