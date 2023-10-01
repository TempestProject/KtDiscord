@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.guild

import cloud.drakon.ktdiscord.permissions.Role
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property nick This user's guild nickname.
 * @property avatar The member's [guild avatar hash](https://discord.com/developers/docs/reference#image-formatting).
 * @property roles [Array] of [Role] object IDs.
 * @property joinedAt When the user joined the guild.
 * @property premiumSince When the user started [boosting](https://support.discord.com/hc/en-us/articles/360028038352-Server-Boosting) the guild.
 * @property flags [GuildMemberFlags] represented as a bit set, defaults to 0.
 * @property pending Whether the user has not yet passed the guild's [Membership Screening](https://discord.com/developers/docs/resources/guild#membership-screening-object) requirements.
 * @property permissions Total permissions of the member in the channel, including overwrites, returned when in the [Interaction] object.
 * @property communicationDisabledUntil When the user's [timeout](https://support.discord.com/hc/en-us/articles/4413305239191-Time-Out-FAQ) will expire and the user will be able to communicate in the guild again, `null` or a time in the past if the user is not timed out.
 */
@JsExport @Serializable
class GuildMember(
    val nick: String? = null,
    val avatar: String? = null,
    val roles: Array<Role>,
    @SerialName("joined_at") val joinedAt: String,
    @SerialName("premium_since") val premiumSince: String? = null,
    val flags: Int,
    val pending: Boolean? = null,
    val permissions: String? = null,
    val communicationDisabledUntil: String? = null,
)
