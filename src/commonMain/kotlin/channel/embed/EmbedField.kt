@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.embed

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property name Name of the field.
 * @property value Value of the field.
 * @property inline Whether or not this field should display inline.
 */
@JsExport @Serializable
data class EmbedField(val name: String, val value: String, val inline: Boolean? = null)
