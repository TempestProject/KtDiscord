@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.component

import cloud.drakon.ktdiscord.emoji.Emoji
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property label User-facing name of the option; max 100 characters.
 * @property value Dev-defined value of the option; max 100 characters.
 * @property description Additional description of the option; max 100 characters.
 * @property emoji `id`, `name`, and `animated`.
 * @property default Will show this option as selected by default.
 */
@JsExport @Serializable
data class SelectOption(
    val label: String,
    val value: String,
    val description: String? = null,
    val emoji: Emoji? = null,
    val default: Boolean? = null,
)
