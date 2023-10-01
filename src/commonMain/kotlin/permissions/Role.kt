@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.permissions

import cloud.drakon.ktdiscord.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Roles represent a set of permissions attached to a group of users. Roles have names, colors, and can be "pinned" to the side bar, causing their members to be listed separately. Roles can have separate permission profiles for the global context (guild) and channel context. The `@everyone` role has the same ID as the guild it belongs to.
 * @property id Role ID.
 * @property name Role name.
 * @property color [Int] representation of hexadecimal color code.
 * @property hoist If this role is pinned in the user listing.
 * @property icon Role [icon hash](https://discord.com/developers/docs/reference#image-formatting).
 * @property unicodeEmoji Role unicode emoji.
 * @property position Position of this role.
 * @property permissions Permission bit set.
 * @property managed Whether this role is managed by an integration.
 * @property mentionable Whether this role is mentionable.
 * @property tags The tags this role has.
 * @property flags [RoleFlags] combined as a [bitfield](https://en.wikipedia.org/wiki/Bit_field).
 */
@JsExport @Serializable
class Role(
    val id: Snowflake,
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
    val flags: Int,
)
