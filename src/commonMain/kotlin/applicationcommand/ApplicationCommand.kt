package cloud.drakon.ktdiscord.applicationcommand

import cloud.drakon.ktdiscord.applicationcommand.option.ApplicationCommandOption
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Application commands are native ways to interact with apps in the Discord client. There are 3 types of commands accessible in different interfaces: the chat input, a message's context menu (top-right menu or right-clicking in a message), and a user's context menu (right-clicking on a user).
 *
 * @property id Unique ID of command
 * @property type Type of command, defaults to `1`
 * @property applicationId ID of the parent application
 * @property guildId Guild ID of the command, if not global
 * @property name Name of command, 1-32 characters
 * @property nameLocalizations Localization dictionary for `name` field. Values follow the same restrictions as `name`
 * @property description Description for `CHAT_INPUT` commands, 1-100 characters. Empty string for `USER` and `MESSAGE` commands
 * @property descriptionLocalizations Localization dictionary for `description` field. Values follow the same restrictions as `description`
 * @property options Parameters for the command, max of 25
 * @property defaultMemberPermissions Set of permissions represented as a bit set
 * @property dmPermission Indicates whether the command is available in DMs with the app, only for globally-scoped commands. By default, commands are visible.
 * @property defaultPermission Not recommended for use as field will soon be deprecated. Indicates whether the command is enabled by default when the app is added to a guild, defaults to `true`
 * @property nsfw Indicates whether the command is age-restricted, defaults to `false`
 * @property version Autoincrementing version identifier updated during substantial record changes
 */
@JsExport @Serializable class ApplicationCommand(
    val id: String,
    val type: Byte? = null,
    @SerialName("application_id") val applicationId: String,
    @SerialName("guild_id") val guildId: String? = null,
    val name: String,
    @SerialName("name_localizations")
    val nameLocalizations: Map<String, String>? = null,
    val description: String = "",
    @SerialName("description_localizations")
    val descriptionLocalizations: Map<String, String>? = null,
    val options: Array<ApplicationCommandOption>? = null,
    @SerialName("default_member_permissions")
    val defaultMemberPermissions: String? = null,
    @SerialName("dm_permission") val dmPermission: Boolean? = null,
    @Deprecated("Not recommended for use as field will soon be deprecated.")
    @SerialName("default_permission") val defaultPermission: Boolean? = null,
    val nsfw: Boolean? = null,
    val version: String,
)
