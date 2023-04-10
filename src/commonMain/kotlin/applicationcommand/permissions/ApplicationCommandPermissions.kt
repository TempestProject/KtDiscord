package cloud.drakon.ktdiscord.applicationcommand.permissions

import kotlinx.serialization.Serializable

/**
 * Application command permissions allow you to enable or disable commands for specific users, roles, or channels within a guild.
 *
 * @property id ID of the role, user, or channel. It can also be a permission constant
 * @property type role (`1`), user (`2`), or channel (`3`)
 * @property permission `true` to allow, `false` to disallow
 */
@Serializable class ApplicationCommandPermissions(
    val id: String,
    val type: Byte,
    val permission: Boolean,
)
