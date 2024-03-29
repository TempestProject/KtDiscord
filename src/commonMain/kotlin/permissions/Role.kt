package cloud.drakon.ktdiscord.permissions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Roles represent a set of permissions attached to a group of users. Roles have names, colors, and can be "pinned" to the side bar, causing their members to be listed separately. Roles can have separate permission profiles for the global context (guild) and channel context. The `@everyone` role has the same ID as the guild it belongs to.
 * @property id role id
 * @property name role name
 * @property color integer representation of hexadecimal color code
 * @property hoist if this role is pinned in the user listing
 * @property icon role icon hash
 * @property unicodeEmoji role unicode emoji
 * @property position position of this role
 * @property permissions permission bit set
 * @property managed whether this role is managed by an integration
 * @property mentionable whether this role is mentionable
 * @property tags the tags this role has
 */
@Serializable class Role(
    val id: String,
    val name: String,
    val color: Int,
    val hoist: Boolean,
    val icon: String? = null,
    @SerialName("unicode_emoji") val unicodeEmoji: String? = null,
    val position: Int,
    val permissions: String? = null,
    val managed: Boolean,
    val mentionable: Boolean,
    val tags: RoleTags,
)
