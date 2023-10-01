@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.permissions

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport
object RoleFlags {
    /** [Role] can be selected by members in an onboarding prompt. */
    const val IN_PROMPT = 1 shl 0
}
