package cloud.drakon.tempest.components.selectmenu

import cloud.drakon.tempest.components.Emoji

class TextSelectMenu(
    val custom_id: String,
    val options: Array<SelectOption>,
    val placeholder: String?,
    val min_values: Byte?,
    val max_values: Byte?,
    val disabled: Boolean?
) {
    val type: Byte = 3
}

class SelectOption(
    val label: String,
    val value: String,
    val description: String?,
    val emoji: Emoji?,
    val default: Boolean?
)
