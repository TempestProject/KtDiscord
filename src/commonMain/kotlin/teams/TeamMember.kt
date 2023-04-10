package cloud.drakon.ktdiscord.teams

import cloud.drakon.ktdiscord.user.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property membershipState the user's membership state on the team
 * @property permissions will always be ["*"]
 * @property teamId the id of the parent team of which they are a member
 * @property user the avatar, discriminator, id, and username of the user
 */
@Serializable class TeamMember(
    @SerialName("membership_state") val membershipState: Byte,
    val permissions: Array<String>,
    @SerialName("team_id") val teamId: String,
    val user: User,
)
