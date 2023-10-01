@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.user

import cloud.drakon.ktdiscord.Locale
import cloud.drakon.ktdiscord.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Users in Discord are generally considered the base entity. Users can spawn across the entire platform, be members of guilds, participate in text and voice chat, and much more. Users are separated by a distinction of "bot" vs "normal." Although they are similar, bot users are automated users that are "owned" by another user.
 * @property id The user's ID.
 * @property username The user's username, not unique across the platform.
 * @property discriminator The user's Discord-tag.
 * @property globalName The user's display name, if it is set. For bots, this is the application name.
 * @property avatar The user's [avatar hash](https://discord.com/developers/docs/reference#image-formatting).
 * @property bot Whether the user belongs to an OAuth2 application.
 * @property system Whether the user is an Official Discord System user (part of the urgent message system).
 * @property mfaEnabled Whether the user has two factor enabled on their account.
 * @property banner The user's [banner hash](https://discord.com/developers/docs/reference#image-formatting).
 * @property accentColor The user's banner color encoded as an integer representation of hexadecimal color code.
 * @property locale The user's chosen language option.
 * @property verified Whether the email on this account has been verified.
 * @property email The user's email.
 * @property flags The flags on a user's account.
 * @property premiumType The type of Nitro subscription on a user's account.
 * @property publicFlags The public flags on a user's account.
 * @property avatarDecoration The user's [avatar decoration hash](https://discord.com/developers/docs/reference#image-formatting).
 */
@JsExport @Serializable
class User(
    val id: Snowflake,
    val username: String,
    @Deprecated("https://support.discord.com/hc/en-us/articles/12620128861463-New-Usernames-Display-Names") val discriminator: String,
    @SerialName("global_name") val globalName: String? = null,
    val avatar: String? = null,
    val bot: Boolean? = null,
    val system: Boolean? = null,
    @SerialName("mfa_enabled") val mfaEnabled: Boolean? = null,
    val banner: String? = null,
    @SerialName("accent_color") val accentColor: Int? = null,
    val locale: Locale? = null,
    val verified: Boolean? = null,
    val email: String? = null,
    val flags: Int? = null,
    @SerialName("premium_type") val premiumType: PremiumType? = null,
    @SerialName("public_flags") val publicFlags: Int? = null,
    @SerialName("avatar_decoration") val avatarDecoration: String? = null,
)
