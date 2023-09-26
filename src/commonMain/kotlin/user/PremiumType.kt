package cloud.drakon.ktdiscord.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable enum class PremiumType {
    @SerialName("0") NONE,
    @SerialName("1") NITRO_CLASSIC,
    @SerialName("2") NITRO,
    @SerialName("3") NITRO_BASIC
}
