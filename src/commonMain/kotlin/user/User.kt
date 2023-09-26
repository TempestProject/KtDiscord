package cloud.drakon.ktdiscord.user

import cloud.drakon.ktdiscord.reference.Locale
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable class User(
    val id: String,
    val username: String,
    @Deprecated("") val discriminator: String,
    @SerialName("global_name") val globalName: String? = null,
    val avatar: String? = null,
    val bot: Boolean? = null,
    val system: Boolean? = null,
    @SerialName("mfa_enabled") val mfaEnabled: Boolean? = null,
    val banner: String? = null,
    @SerialName("accent_color") val accentColor: Int? = null,
    val locale: Locale? = null,
    val verified: Boolean? = null,
    val email: Boolean? = null,
    val flags: Int? = null,
    @SerialName("premium_type") val premiumType: PremiumType? = null,
    @SerialName("public_flags") val publicFlags: Int? = null,
    @SerialName("avatar_decoration") val avatorDecoration: String? = null,
)
