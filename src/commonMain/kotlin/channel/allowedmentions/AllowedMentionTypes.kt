package cloud.drakon.ktdiscord.channel.allowedmentions

import kotlin.js.JsExport

@JsExport object AllowedMentionTypes {
    /** Controls role mentions */
    const val ROLE_MENTIONS: String = "roles"

    /** Controls user mentions */
    const val USER_MENTIONS: String = "users"

    /** Controls @everyone and @here mentions */
    const val EVERYONE_MENTIONS: String = "everyone"
}
