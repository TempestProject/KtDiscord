package cloud.drakon.ktdiscord.interaction

import cloud.drakon.ktdiscord.guild.GuildMember
import cloud.drakon.ktdiscord.user.User
import kotlinx.serialization.Serializable

@Serializable class MessageInteraction(
    val id: String,
    val type: Int,
    val name: String,
    val user: User,
    val member: GuildMember? = null,
)
