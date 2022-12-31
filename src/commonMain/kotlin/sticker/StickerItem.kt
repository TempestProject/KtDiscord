package cloud.drakon.ktdiscord.sticker

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The smallest amount of data required to render a sticker. A partial sticker object.
 * @property id id of the sticker
 * @property name name of the sticker
 * @property formatType type of sticker format
 */
@JsExport @Serializable class StickerItem(
    val id: String,
    val name: String,
    @SerialName("format_type") val formatType: Byte,
)
