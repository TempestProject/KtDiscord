@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction

import cloud.drakon.ktdiscord.Locale
import cloud.drakon.ktdiscord.Snowflake
import cloud.drakon.ktdiscord.channel.Channel
import cloud.drakon.ktdiscord.channel.message.Message
import cloud.drakon.ktdiscord.entitlement.Entitlement
import cloud.drakon.ktdiscord.guild.GuildMember
import cloud.drakon.ktdiscord.interaction.data.InteractionData
import cloud.drakon.ktdiscord.user.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * An [Interaction](https://discord.com/developers/docs/interactions/receiving-and-responding#interaction-object) is the message that your application receives when a user uses an application command or a message component.
 *
 * For [Slash Commands](https://discord.com/developers/docs/interactions/application-commands#slash-commands), it includes the values that the user submitted.
 *
 * For [User Commands](https://discord.com/developers/docs/interactions/application-commands#user-commands) and [Message Commands](https://discord.com/developers/docs/interactions/application-commands#message-commands), it includes the resolved user or message on which the action was taken.
 *
 * For [Message Components](https://discord.com/developers/docs/interactions/message-components) it includes identifying information about the component that was used. It will also include some metadata about how the interaction was triggered: the [guildId], [channel], [member] and other fields.
 * @property id ID of the interaction.
 * @property applicationId ID of the application this interaction is for.
 * @property type Type of interaction.
 * @property data Interaction data payload.
 * @property guildId Guild that the interaction was sent from.
 * @property channel Channel that the interaction was sent from.
 * @property channelId Channel that the interaction was sent from.
 * @property member Guild member data for the invoking user, including permissions.
 * @property user User object for the invoking user, if invoked in a DM.
 * @property token Continuation token for responding to the interaction.
 * @property version Read-only property, always 1.
 * @property message For components, the message they were attached to.
 * @property appPermissions Bitwise set of permissions the app or bot has within the channel the interaction was sent from.
 * @property locale Selected [Locale] of the invoking user.
 * @property guildLocale [Guild's preferred locale](https://discord.com/developers/docs/resources/guild#guild-object)), if invoked in a guild.
 * @property entitlements For monetized apps, any entitlements for the invoking user, representing access to premium SKUs.
 */
@JsExport @Serializable
class Interaction(
    val id: Snowflake,
    @SerialName("application_id") val applicationId: Snowflake,
    val type: InteractionType,
    val data: InteractionData? = null,
    @SerialName("guild_id") val guildId: Snowflake? = null,
    val channel: Channel? = null,
    @SerialName("channel_id") val channelId: Snowflake? = null,
    val member: GuildMember? = null,
    val user: User? = null,
    val token: String,
    val version: Byte,
    val message: Message? = null,
    @SerialName("app_permissions") val appPermissions: String? = null,
    val locale: Locale? = null,
    @SerialName("guild_locale") val guildLocale: Locale? = null,
    val entitlements: Array<Entitlement>,
)
