package cloud.drakon.ktdiscord.channel.allowedmentions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable enum class AllowedMentionTypes {
    @SerialName("roles") ROLES,
    @SerialName("users") USERS,
    @SerialName("everyone") EVERYONE
}
