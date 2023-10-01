@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.entitlement

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class EntitlementType {
    @SerialName("8") APPLICATION_SUBSCRIPTION,
}
