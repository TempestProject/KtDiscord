package cloud.drakon.ktdiscord.channel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable enum class ChannelType {
    /** A text channel within a server */
    @SerialName("0") GUILD_TEXT,

    /** A voice channel within a server */
    @SerialName("2") GUILD_VOICE,

    /** A channel that [users can follow and crosspost into their own server](https://support.discord.com/hc/en-us/articles/360032008192) (formerly news channels) */
    @SerialName("5") GUILD_ANNOUNCEMENT,

    /** A temporary sub-channel within a [GUILD_ANNOUNCEMENT] channel */
    @SerialName("10") ANNOUNCEMENT_THREAD,

    /** A temporary sub-channel within a [GUILD_TEXT] or [GUILD_FORUM] channel */
    @SerialName("11") PUBLIC_THREAD,

    /** A temporary sub-channel within a [GUILD_TEXT] channel that is only viewable by those invited and those with the [MANAGE_THREADS] permission */
    @SerialName("12") PRIVATE_THREAD,

    /** A voice channel for [hosting events with an audience](https://support.discord.com/hc/en-us/articles/1500005513722) */
    @SerialName("13") GUILD_STAGE_VOICE,

    /** Channel that can only contain threads */
    @SerialName("15") GUILD_FORUM,

    /** Channel that can only contain threads, similar to [GUILD_FORUM] channels */
    @SerialName("16") GUILD_MEDIA
}
