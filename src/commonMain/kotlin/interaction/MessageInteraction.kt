package interaction

import guild.GuildMember
import kotlinx.serialization.Serializable
import user.User

@Serializable class MessageInteraction(
    val id: String,
    val type: Byte,
    val name: String,
    val user: User,
    val member: GuildMember? = null,
)
