@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.guild

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport
object GuildMemberFlags {
    /** Member has left and rejoined the guild. */
    const val DID_REJOIN = 1 shl 0

    /** Member has completed onboarding. */
    const val COMPLETED_ONBOARDING = 1 shl 1

    /** Member is exempt from guild verification requirements. */
    const val BYPASSES_VERIFICATION = 1 shl 2

    /** Member has started onboarding. */
    const val STARTED_ONBOARDING = 1 shl 3
}
