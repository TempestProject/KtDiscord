package cloud.drakon.tempest.interaction

import cloud.drakon.tempest.channel.message.Message
import cloud.drakon.tempest.guild.GuildMember
import cloud.drakon.tempest.user.User
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
 * @property application_id ID of the application this interaction is for
 * @property type Type of interaction
 * @property data Interaction data payload
 * @property guild_id Guild that the interaction was sent from
 * @property channel_id Channel that the interaction was sent from
 * @property member Guild member data for the invoking user, including permissions
 * @property user User object for the invoking user, if invoked in a DM
 * @property token Continuation token for responding to the interaction
 * @property version Read-only property, always 1
 * @property message For components, the message they were attached to
 * @property app_permissions Bitwise set of permissions the app or bot has within the channel the interaction was sent from
 * @property locale Selected language of the invoking user
 * @property guild_locale Guild's preferred locale, if invoked in a guild
 */
@Serializable class Interaction<T: InteractionData?>(
    val id: String,
    val application_id: String,
    val type: Int,
    val data: T? = null,
    val guild_id: String? = null,
    val channel_id: String? = null,
    val member: GuildMember? = null,
    val user: User? = null,
    val token: String,
    val version: Byte,
    val message: Message? = null,
    val app_permissions: String? = null,
    val locale: String? = null,
    val guild_locale: String? = null,
    val entitlement_sku_ids: Array<String>? = null, // TODO undocumented
)
