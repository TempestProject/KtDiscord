package cloud.drakon.ktdiscord.permissions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable class Role(
    val id: String,
    val name: String,
    val color: Int,
    val hoist: Boolean,
    val icon: String? = null,
    @SerialName("unicode_emoji") val unicodeEmoji: String? = null,
    val position: Int,
    val permissions: String,
    val managed: Boolean,
    val mentionable: Boolean,
    val tags: Array<RoleTag>? = null,
    val flags: Int,
)
