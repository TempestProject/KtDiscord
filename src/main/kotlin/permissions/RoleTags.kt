package cloud.drakon.discordkt.permissions

import kotlinx.serialization.Serializable

/**
 * @property bot_id the id of the bot this role belongs to
 * @property integration_id the id of the integration this role belongs to
 * @property premium_subscriber whether this is the guild's premium subscriber role
 */
@Serializable class RoleTags(
    val bot_id: String? = null,
    val integration_id: String? = null,
)
