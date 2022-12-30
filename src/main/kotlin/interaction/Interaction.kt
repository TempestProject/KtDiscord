package cloud.drakon.ktdiscord.interaction

import cloud.drakon.ktdiscord.channel.message.Message
import cloud.drakon.ktdiscord.guild.GuildMember
import cloud.drakon.ktdiscord.user.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An Interaction is the message that your application receives when a user uses an application command or a message components.
 *
 * For Slash Commands, it includes the values that the user submitted.
 *
 * For User Commands and Message Commands, it includes the resolved user or message on which the action was taken.
 *
 * For Message Components it includes identifying information about the components that was used. It will also include some metadata about how the interaction was triggered: the guild_id, channel_id, member and other fields. You can find all the values in our data models below.
 * @property id ID of the interaction
 * @property applicationId ID of the application this interaction is for
 * @property type Type of interaction
 * @property data Interaction data payload
 * @property guildId Guild that the interaction was sent from
 * @property channelId Channel that the interaction was sent from
 * @property member Guild member data for the invoking user, including permissions
 * @property user User object for the invoking user, if invoked in a DM
 * @property token Continuation token for responding to the interaction
 * @property version Read-only property, always 1
 * @property message For components, the message they were attached to
 * @property appPermissions Bitwise set of permissions the app or bot has within the channel the interaction was sent from
 * @property locale Selected language of the invoking user
 * @property guildLocale Guild's preferred locale, if invoked in a guild
 */
@Serializable class Interaction<T: InteractionData?>(
    val id: String,
    @SerialName("application_id") val applicationId: String,
    val type: Int,
    val data: T? = null,
    @SerialName("guild_id") val guildId: String? = null,
    @SerialName("channel_id") val channelId: String? = null,
    val member: GuildMember? = null,
    val user: User? = null,
    val token: String,
    val version: Byte,
    val message: Message? = null,
    @SerialName("app_permissions") val appPermissions: String? = null,
    val locale: String? = null,
    @SerialName("guild_locale") val guildLocale: String? = null,
)
