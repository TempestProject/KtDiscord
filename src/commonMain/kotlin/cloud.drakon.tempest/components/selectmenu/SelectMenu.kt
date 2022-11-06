package cloud.drakon.tempest.components.selectmenu

class SelectMenu(
    val type: SelectMenuType,
    val custom_id: String,
    val placeholder: String?,
    val min_values: Byte?,
    val max_values: Byte?,
    val disabled: Boolean?
)

enum class SelectMenuType(val SelectMenuType: Byte) {
    USER(5),
    ROLE(6),
    MENTIONABLE(7)
}
