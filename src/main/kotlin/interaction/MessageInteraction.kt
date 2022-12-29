package cloud.drakon.tempest.interaction

import cloud.drakon.tempest.guild.GuildMember
import cloud.drakon.tempest.user.User
import kotlinx.serialization.Serializable

@Serializable class MessageInteraction(
    val id: String,
    val type: Byte,
    val name: String,
    val user: User,
    val member: GuildMember? = null,
)
