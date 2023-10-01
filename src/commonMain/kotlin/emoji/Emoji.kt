@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.emoji

import cloud.drakon.ktdiscord.Snowflake
import cloud.drakon.ktdiscord.permissions.Role
import cloud.drakon.ktdiscord.user.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property id Emoji ID.
 * @property name Emoji name. Can be `null` only in reaction emoji objects.
 * @property roles [Role]s allowed to use this emoji.
 * @property user [User] that created this emoji.
 * @property requireColons Whether this emoji must be wrapped in colons.
 * @property managed Whether this emoji is managed.
 * @property animated Whether this emoji is animated.
 * @property available Whether this emoji can be used, may be false due to loss of Server Boosts.
 */
@JsExport @Serializable
class Emoji(
    val id: Snowflake? = null,
    val name: String? = null,
    val roles: Array<Role>? = null,
    val user: User? = null,
    @SerialName("require_colons") val requireColons: Boolean? = null,
    val managed: Boolean? = null,
    val animated: Boolean? = null,
    val available: Boolean? = null,
)
