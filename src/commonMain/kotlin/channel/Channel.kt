@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel

import cloud.drakon.ktdiscord.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Represents a guild or DM channel within Discord.
 * @property id The ID of this channel.
 * @property type The type of channel.
 * @property guildId The ID of the guild.
 * @property position Sorting position of the channel.
 * @property name The name of the channel.
 * @property topic The channel topic.
 * @property nsfw Whether the channel is NSFW.
 * @property lastMessageId The ID of the last message sent in this channel (or thread for [ChannelType.GUILD_FORUM] or [ChannelType.GUILD_MEDIA] channels) (may not point to an existing or valid message or thread).
 * @property rateLimitPerUser amount of seconds a user has to wait before sending another message; bots, as well as users with the permission `MANAGE_MESSAGES` or `MANAGE_CHANNEL`, are unaffected.
 * @property parentId For guild channels: ID of the parent category for a channel (each parent category can contain up to 50 channels), for threads: ID of the text channel this thread was created.
 * @property permissions Computed permissions for the invoking user in the channel, including overwrites, only included when part of the `resolved` data received on a slash command interaction. This does not include [implicit permissions](https://discord.com/developers/docs/topics/permissions#implicit-permissions), which may need to be checked separately.
 * @property flags [ChannelFlags] combined as a [bitfield](https://en.wikipedia.org/wiki/Bit_field).
 */
@JsExport @Serializable
class Channel(
    val id: Snowflake,
    val type: ChannelType,
    @SerialName("guild_id") val guildId: Snowflake? = null,
    val position: Int,
    val name: String? = null,
    val topic: String? = null,
    val nsfw: Boolean? = null,
    @SerialName("last_message_id") val lastMessageId: Snowflake? = null,
    @SerialName("rate_limit_per_user") val rateLimitPerUser: Short? = null,
    @SerialName("parent_id") val parentId: Snowflake? = null,
    val flags: Int? = null,
)
