package cloud.drakon.ktdiscord.emoji

import kotlinx.serialization.Serializable

@Serializable class Emoji(
    val id: String,
    val name: String,
    val animated: Boolean? = null,
)
