@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.allowedmentions

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable enum class AllowedMentionTypes {
    @SerialName("roles") ROLES,
    @SerialName("users") USERS,
    @SerialName("everyone") EVERYONE
}
