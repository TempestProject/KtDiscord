@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.component

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport sealed interface Component {
    val type: Byte
}
