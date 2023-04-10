package cloud.drakon.ktdiscord.teams

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property icon a hash of the image of the team's icon
 * @property id the unique id of the team
 * @property members the members of the team
 * @property name the name of the team
 * @property ownerUserId the user id of the current team owner
 */
@Serializable class Team(
    val icon: String?,
    val id: String,
    val members: Array<TeamMember>,
    val name: String,
    @SerialName("owner_user_id") val ownerUserId: String,
)
