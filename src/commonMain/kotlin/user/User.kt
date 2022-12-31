package cloud.drakon.ktdiscord.user

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Users in Discord are generally considered the base entity. Users can spawn across the entire platform, be members of guilds, participate in text and voice chat, and much more. Users are separated by a distinction of "bot" vs "normal." Although they are similar, bot users are automated users that are "owned" by another user. Unlike normal users, bot users do not have a limitation on the number of Guilds they can be a part of.
 *
 * **Usernames and Nicknames**
 *
 * Discord enforces the following restrictions for usernames and nicknames:
 * - Names can contain most valid unicode characters. We limit some zero-width and non-rendering characters.
 * - Usernames must be between 2 and 32 characters long.
 * - Nicknames must be between 1 and 32 characters long.
 * - Names are sanitized and trimmed of leading, trailing, and excessive internal whitespace.
 * The following restrictions are additionally enforced for usernames:
 * - Usernames cannot contain the following substrings: `@`, `#`, `:`, ` ```, `discord`
 * - Usernames cannot be: `everyone`, `here`
 *
 * There are other rules and restrictions not shared here for the sake of spam and abuse mitigation, but the majority of users won't encounter them. It's important to properly handle all error messages returned by Discord when editing or updating names.
 * @property id the user's id
 * @property username the user's username, not unique across the platform
 * @property discriminator the user's 4-digit discord-tag
 * @property avatar the user's avatar hash
 * @property bot whether the user belongs to an OAuth2 application
 * @property system whether the user is an Official Discord System user (part of the urgent message system)
 * @property mfa_enabled whether the user has two factor enabled on their account
 * @property banner the user's banner hash
 * @property accent_color the user's banner color encoded as an integer representation of hexadecimal color code
 * @property locale the user's chosen language option
 * @property verified whether the email on this account has been verified
 * @property email the user's email
 * @property flags the flags on a user's account
 * @property premium_type the type of Nitro subscription on a user's account
 * @property public_flags the public flags on a user's account
 */
@JsExport @Serializable class User(
    val id: String,
    val username: String,
    val discriminator: String,
    val avatar: String?,
    val bot: Boolean? = null,
    val system: String? = null,
    @SerialName("mfa_enabled") val mfaEnabled: Boolean? = null,
    val banner: String? = null,
    @SerialName("accent_color") val accentColor: Int? = null,
    val locale: String? = null,
    val verified: String? = null,
    val email: String? = null,
    val flags: Int? = null,
    @SerialName("premium_type") val premiumType: Byte? = null,
    @SerialName("public_flags") val publicFlags: Int? = null,
)
