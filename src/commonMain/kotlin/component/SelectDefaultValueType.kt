@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.component

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class SelectDefaultValueType {
    @SerialName("user") USER,
    @SerialName("role") ROLE,
    @SerialName("channel") CHANNEL
}
