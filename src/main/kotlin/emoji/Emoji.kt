package cloud.drakon.discordkt.emoji

import cloud.drakon.discordkt.permissions.Role
import cloud.drakon.discordkt.user.User
import kotlinx.serialization.Serializable

/**
 * @property id emoji id
 * @property name emoji name
 * @property roles roles allowed to use this emoji
 * @property user user that created this emoji
 * @property require_colons whether this emoji must be wrapped in colons
 * @property managed whether this emoji is managed
 * @property animated whether this emoji is animated
 * @property available whether this emoji can be used, may be false due to loss of Server Boosts
 */
@Serializable class Emoji(
    val id: String?,
    val name: String?,
    val roles: Array<Role>? = null,
    val user: User? = null,
    val require_colons: Boolean? = null,
    val managed: Boolean? = null,
    val animated: Boolean? = null,
    val available: Boolean? = null,
)
