@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.component

import cloud.drakon.ktdiscord.interaction.component.button.ButtonStyle
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable class Button(val style: ButtonStyle, val label: String? = null):
    Component {
    override val type = 2
}
