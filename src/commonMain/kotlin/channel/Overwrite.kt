package cloud.drakon.ktdiscord.channel

import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * @property id role or user id
 * @property type either 0 (role) or 1 (member)
 * @property allow permission bit set
 * @property deny permission bit set
 */
@JsExport @Serializable class Overwrite(
    val id: String,
    val type: Byte,
    val allow: String,
    val deny: String,
)
