package cloud.drakon.tempest.teams

import kotlinx.serialization.Serializable

/**
 * @property icon a hash of the image of the team's icon
 * @property id the unique id of the team
 * @property members the members of the team
 * @property name the name of the team
 * @property owner_user_id the user id of the current team owner
 */
@Serializable class Team(
    val icon: String?,
    val id: String,
    val members: Array<TeamMember>,
    val name: String,
    val owner_user_id: String,
)
