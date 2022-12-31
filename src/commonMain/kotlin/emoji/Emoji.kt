package cloud.drakon.ktdiscord.emoji

import cloud.drakon.ktdiscord.permissions.Role
import cloud.drakon.ktdiscord.user.User
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property id emoji id
 * @property name emoji name
 * @property roles roles allowed to use this emoji
 * @property user user that created this emoji
 * @property requireColons whether this emoji must be wrapped in colons
 * @property managed whether this emoji is managed
 * @property animated whether this emoji is animated
 * @property available whether this emoji can be used, may be false due to loss of Server Boosts
 */
@JsExport @Serializable class Emoji(
    val id: String?,
    val name: String?,
    val roles: Array<Role>? = null,
    val user: User? = null,
    @SerialName("require_colons") val requireColons: Boolean? = null,
    val managed: Boolean? = null,
    val animated: Boolean? = null,
    val available: Boolean? = null,
)
