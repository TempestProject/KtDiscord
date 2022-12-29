package cloud.drakon.tempest.teams

import cloud.drakon.tempest.user.User
import kotlinx.serialization.Serializable

/**
 * @property membership_state the user's membership state on the team
 * @property permissions will always be ["*"]
 * @property team_id the id of the parent team of which they are a member
 * @property user the avatar, discriminator, id, and username of the user
 */
@Serializable class TeamMember(
    val membership_state: Byte,
    val permissions: Array<String>,
    val team_id: String,
    val user: User,
)
