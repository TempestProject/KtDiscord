@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.component

import cloud.drakon.ktdiscord.emoji.Emoji
import cloud.drakon.ktdiscord.interaction.component.button.ButtonStyle
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable class Button(
    val style: ButtonStyle,
    val label: String? = null,
    val emoji: Emoji? = null,
    @SerialName("custom_id") val customId: String? = null,
    val url: String? = null,
    val disabled: Boolean? = null,
): Component {
    override val type: Byte = 2
}
