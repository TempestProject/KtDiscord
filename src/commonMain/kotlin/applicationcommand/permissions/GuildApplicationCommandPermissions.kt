package cloud.drakon.ktdiscord.applicationcommand.permissions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Returned when fetching the permissions for an app's command(s) in a guild.
 *
 * When the id field is the application ID instead of a command ID, the permissions apply to all commands that do not contain explicit overwrites.
 *
 * @property id ID of the command or the application ID
 * @property applicationId ID of the application the command belongs to
 * @property guildId ID of the guild
 * @property permissions Permissions for the command in the guild, max of 100
 */
@Serializable class GuildApplicationCommandPermissions(
    val id: String,
    @SerialName("application_id") val applicationId: String,
    @SerialName("guild_id") val guildId: String,
    val permissions: Array<ApplicationCommandPermissions>,
)
