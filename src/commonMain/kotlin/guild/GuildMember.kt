package cloud.drakon.tempest.guild

import cloud.drakon.tempest.user.User
import kotlinx.serialization.Serializable

@Serializable class GuildMember(
    val user: User? = null,
    val nick: String? = null,
    val avatar: String? = null,
    val roles: Array<String>,
    val joined_at: String,
    val premium_since: String? = null,
    val deaf: Boolean? = null, // TODO https://github.com/discord/discord-api-docs/issues/5728
    val mute: Boolean? = null, // TODO https://github.com/discord/discord-api-docs/issues/5728
    val pending: Boolean? = null,
    val permissions: String? = null,
    val communication_disabled_until: String? = null,
    val flags: Byte? = null, // TODO undocumented
    val is_pending: Boolean? = null, // TODO undocumented
)
