@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.data

import cloud.drakon.ktdiscord.Snowflake
import cloud.drakon.ktdiscord.guild.GuildMember
import cloud.drakon.ktdiscord.permissions.Role
import cloud.drakon.ktdiscord.user.User
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property users The IDs and [User] objects.
 * @property members The IDs and partial [GuildMember] objects. Partial [GuildMember] objects are missing `user`, `deaf` and `mute` fields.
 * @property roles The IDs and [Role] objects.
 * @property channels The IDs and partial [Channel] objects. Partial [Channel] objects only have `id`, `name`, `type` and `permissions` fields. Threads will also have `threadMetadata` and `parentId` fields.
 * @property messages The IDs and partial [Message] objects.
 * @property attachments The IDs and [Attachment] objects.
 */
@JsExport @Serializable
data class ResolvedData(
    val users: Map<Snowflake, User>? = null,
    val members: Map<Snowflake, GuildMember>? = null,
    val roles: Map<Snowflake, Role>? = null,
    //TODO val channels: Map<Snowflake, Channel>? = null,
    //TODO val messages: Map<Snowflake, Message>? = null,
    //TODO val attachments: Map<Snowflake, Attachment>? = null,
)
