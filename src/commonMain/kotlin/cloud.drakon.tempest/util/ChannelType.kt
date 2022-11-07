package cloud.drakon.tempest.util

enum class ChannelType(val ChannelType: Byte) {
    /** A text channel within a server. */
    GUILD_TEXT(0),
    /** A direct message between users. */
    DM(1),
    /** A voice channel within a server. */
    GUILD_VOICE(2),
    /** A direct message between multiple users. */
    GROUP_DM(3),
    /** An organizational category that contains up to 50 channels. */
    GUILD_CATEGORY(4),
    /** A channel that users can follow and crosspost into their own server. */
    GUILD_ANNOUNCEMENT(5),
    /** A temporary sub-channel within a GUILD_ANNOUNCEMENT channel. */
    ANNOUNCEMENT_THREAD(10),
    /** A temporary sub-channel within a GUILD_TEXT or GUILD_FORUM channel. */
    PUBLIC_THREAD(11),
    /** A temporary sub-channel within a GUILD_TEXT channel that is only viewable by those invited and those with the MANAGE_THREADS permission. */
    PRIVATE_THREAD(12),
    /** A voice channel for hosting events with an audience. */
    GUILD_STAGE_VOICE(13),
    /** The channel in a hub containing the listed servers. */
    GUILD_DIRECTORY(14),
    /** Channel that can only contain threads. */
    GUILD_FORUM(15)
}
