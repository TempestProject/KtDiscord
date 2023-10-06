@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class PremiumType {
    /** None */
    @SerialName("0") NONE,

    /** Nitro Classic */
    @SerialName("1") NITRO_CLASSIC,

    /** Nitro */
    @SerialName("2") NITRO,

    /** Nitro Basic */
    @SerialName("3") NITRO_BASIC,
}
