@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.component.button

import cloud.drakon.ktdiscord.interaction.component.ActionRow
import cloud.drakon.ktdiscord.interaction.component.ComponentType
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable class Button(val style: ButtonStyle, val label: String? = null):
    ActionRow(ComponentType.BUTTON)
