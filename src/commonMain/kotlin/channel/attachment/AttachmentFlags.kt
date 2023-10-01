@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.attachment

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport
object AttachmentFlags {
    /** This attachment has been edited using the remix feature on mobile. */
    const val IS_REMIX = 1 shl 2
}
