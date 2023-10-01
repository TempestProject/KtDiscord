@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class ChannelType {
    /** A text channel within a server. */
    @SerialName("0") GUILD_TEXT,

    /** A direct message between users. */
    @SerialName("1") DM,

    /** A voice channel within a server. */
    @SerialName("2") GUILD_VOICE,

    /** A direct message between multiple users. */
    @SerialName("3") GROUP_DM,

    /** An [organizational category](https://support.discord.com/hc/en-us/articles/115001580171-Channel-Categories-101) that contains up to 50 channels. */
    @SerialName("4") GUILD_CATEGORY,

    /** A channel that [users can follow and crosspost into their own server](https://support.discord.com/hc/en-us/articles/360032008192) (formerly news channels). */
    @SerialName("5") GUILD_ANNOUNCEMENT,

    /** A temporary sub-channel within a [GUILD_ANNOUNCEMENT] channel. */
    @SerialName("10") ANNOUNCEMENT_THREAD,

    /** A temporary sub-channel within a [GUILD_TEXT] or [GUILD_FORUM] channel. */
    @SerialName("11") PUBLIC_THREAD,

    /** A temporary sub-channel within a [GUILD_TEXT] channel that is only viewable by those invited and those with the `MANAGE_THREADS` permission. */
    @SerialName("12") PRIVATE_THREAD,

    /** A voice channel for [hosting events with an audience](https://support.discord.com/hc/en-us/articles/1500005513722). */
    @SerialName("13") GUILD_STAGE_VOICE,

    /** The channel in a [hub](https://support.discord.com/hc/en-us/articles/4406046651927-Discord-Student-Hubs-FAQ) containing the listed servers. */
    @SerialName("14") GUILD_DIRECTORY,

    /** Channel that can only contain threads. */
    @SerialName("15") GUILD_FORUM,

    /** Channel that can only contain threads, similar to [GUILD_FORUM] channels. */
    @SerialName("16") GUILD_MEDIA,
}
