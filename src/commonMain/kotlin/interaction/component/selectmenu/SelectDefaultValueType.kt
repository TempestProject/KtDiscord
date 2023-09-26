@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.component.selectmenu

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable enum class SelectDefaultValueType {
    @SerialName("user") USER, @SerialName("role") ROLE, @SerialName("channel") CHANNEL
}
