package cloud.drakon.ktdiscord.channel

import kotlinx.serialization.Serializable

@Serializable class Attachment(
    val filename: String,
    val description: String? = null,
)
