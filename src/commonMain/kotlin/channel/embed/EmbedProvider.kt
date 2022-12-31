package cloud.drakon.ktdiscord.channel.embed

import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * @property name name of provider
 * @property url url of provider
 */
@JsExport @Serializable class EmbedProvider(
    val name: String? = null,
    val url: String? = null,
)
