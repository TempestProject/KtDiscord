package cloud.drakon.tempest.components.selectmenu

import cloud.drakon.tempest.util.ChannelType

class ChannelSelectMenu(
    val custom_id: String,
    val channel_types: Array<ChannelType>,
    val placeholder: String?,
    val min_values: Byte?,
    val max_values: Byte?,
    val disabled: Boolean?
) {
    val type: Byte = 8
}

