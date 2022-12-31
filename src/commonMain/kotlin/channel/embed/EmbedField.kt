package cloud.drakon.ktdiscord.channel.embed

import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * @property name name of the field
 * @property value value of the field
 * @property inline whether or not this field should display inline
 */
@JsExport @Serializable class EmbedField(
    val name: String,
    val value: String,
    val inline: Boolean? = null,
)
