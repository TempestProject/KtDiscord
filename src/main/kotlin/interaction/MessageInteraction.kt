package cloud.drakon.discordkt.interaction

import cloud.drakon.discordkt.guild.GuildMember
import cloud.drakon.discordkt.user.User
import kotlinx.serialization.Serializable

@Serializable class MessageInteraction(
    val id: String,
    val type: Byte,
    val name: String,
    val user: User,
    val member: GuildMember? = null,
)
