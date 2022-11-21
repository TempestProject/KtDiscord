package cloud.drakon.tempest.sticker

import kotlinx.serialization.Serializable

/**
 * The smallest amount of data required to render a sticker. A partial sticker object.
 * @property id id of the sticker
 * @property name name of the sticker
 * @property format_type type of sticker format
 */
@Serializable class StickerItem(val id: String, val name: String, val format_type: Byte)
