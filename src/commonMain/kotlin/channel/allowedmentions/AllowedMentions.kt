@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.allowedmentions

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable class AllowedMentions(
    val parse: Array<AllowedMentionTypes>,
    val roles: Array<String>,
    val users: Array<String>,
    @SerialName("replied_user") val repliedUser: Boolean = false,
)
