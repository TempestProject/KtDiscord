@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.embed

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property name Name of provider.
 * @property url URL of provider.
 */
@JsExport @Serializable
data class EmbedProvider(val name: String? = null, val url: String? = null)
