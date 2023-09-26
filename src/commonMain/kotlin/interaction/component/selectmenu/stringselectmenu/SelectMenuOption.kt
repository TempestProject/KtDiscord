@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.component.selectmenu.stringselectmenu

import cloud.drakon.ktdiscord.emoji.Emoji
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable class SelectMenuOption(
    val label: String,
    val value: String,
    val description: String? = null,
    val emoji: Emoji? = null,
    val default: Boolean? = null,
)
