@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.component

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable sealed class ActionRow(val type: ComponentType)
