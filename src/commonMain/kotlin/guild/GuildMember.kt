package cloud.drakon.ktdiscord.guild

import cloud.drakon.ktdiscord.user.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable class GuildMember(
    val user: User? = null,
    val nick: String? = null,
    val avatar: String? = null,
    val roles: List<String>,
    @SerialName("joined_at") val joinedAt: String,
    @SerialName("premium_since") val premiumSince: String? = null,
    val deaf: Boolean? = null,
    val mute: Boolean? = null,
    val pending: Boolean? = null,
    val permissions: String? = null,
    @SerialName("communication_disabled_until")
    val communicationDisabledUntil: String? = null,
)
