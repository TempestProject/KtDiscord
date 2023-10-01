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
 * @property name The name of the channel.
 * @property parentId For guild channels: ID of the parent category for a channel (each parent category can contain up to 50 channels), for threads: ID of the text channel this thread was created.
 * @property threadMetadata Thread-specific fields not needed by other channels.
 * @property permissions Computed permissions for the invoking user in the channel, including overwrites, only included when part of the `resolved` data received on a slash command interaction. This does not include [implicit permissions](https://discord.com/developers/docs/topics/permissions#implicit-permissions), which may need to be checked separately.
 */
@JsExport @Serializable
data class Channel(
    val id: Snowflake,
    val type: ChannelType,
    val name: String,
    @SerialName("parent_id") val parentId: Snowflake? = null,
    @SerialName("thread_metadata") val threadMetadata: ThreadMetadata? = null,
    val permissions: String,
)
