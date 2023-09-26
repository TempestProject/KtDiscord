package cloud.drakon.ktdiscord.channel.allowedmentions

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable class AllowedMentions(
    val parse: Array<AllowedMentionTypes>,
    val roles: Array<String>,
    val users: Array<String>,
    @SerialName("replied_user") val repliedUser: Boolean,
)
