@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction

import cloud.drakon.ktdiscord.Snowflake
import cloud.drakon.ktdiscord.guild.GuildMember
import cloud.drakon.ktdiscord.user.User
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * This is sent on the [Message] object when the message is a response to an [Interaction] without an existing message.
 * @property id ID of the [Interaction].
 * @property type Type of [Interaction].
 * @property name Name of the [ApplicationCommand], including subcommands and subcommand groups.
 * @property user [User] who invoked the interaction.
 * @property member [GuildMember] who invoked the interaction in the guild.
 */
@JsExport @Serializable
data class MessageInteraction(
    val id: Snowflake,
    val type: InteractionType,
    val name: String,
    val user: User,
    val member: GuildMember,
)
