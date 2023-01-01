package cloud.drakon.ktdiscord.applicationcommand.permissions

import kotlin.js.JsExport

@JsExport class ApplicationCommandPermissionConstants(val guildId: String) {
    /** All members in a guild */
    val everyone: String = guildId

    /** All channels in a guild */
    val allChannels: String = (guildId.toLong() - 1).toString()
}
