package cloud.drakon.ktdiscord.applicationcommand.permissions

import kotlin.js.JsExport

@JsExport object ApplicationCommandPermissionConstants {
    /** All members in a guild */
    const val everyone = "guild_id"

    /** All channels in a guild */
    const val allChannels = "guild_id - 1"
}
