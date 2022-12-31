package cloud.drakon.ktdiscord.channel

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property id id of the channel
 * @property guildId id of the guild containing the channel
 * @property type the type of channel
 * @property name the name of the channel
 */
@JsExport @Serializable class ChannelMention(
    val id: String,
    @SerialName("guild_id") val guildId: String,
    val type: Byte,
    val name: String,
)
