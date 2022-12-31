package cloud.drakon.ktdiscord.interaction

import cloud.drakon.ktdiscord.guild.GuildMember
import cloud.drakon.ktdiscord.user.User
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable class MessageInteraction(
    val id: String,
    val type: Byte,
    val name: String,
    val user: User,
    val member: GuildMember? = null,
)
