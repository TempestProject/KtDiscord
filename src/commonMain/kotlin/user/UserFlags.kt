@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.user

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport
object UserFlags {
    /** Discord Employee */
    const val STAFF = 1 shl 0

    /** Partnered Server Owner */
    const val PARTNER = 1 shl 1

    /** HypeSquad Events Member */
    const val HYPESQUAD = 1 shl 2

    /** Bug Hunter Level 1 */
    const val BUG_HUNTER_LEVEL_1 = 1 shl 3

    /** House Bravery Member */
    const val HYPESQUAD_ONLINE_HOUSE_1 = 1 shl 6

    /** House Brilliance Member */
    const val HYPESQUAD_ONLINE_HOUSE_2 = 1 shl 7

    /** House Balance Member */
    const val HYPESQUAD_ONLINE_HOUSE_3 = 1 shl 8

    /** Early Nitro Supporter */
    const val PREMIUM_EARLY_SUPPORTER = 1 shl 9

    /** User is a [team](https://discord.com/developers/docs/topics/teams) */
    const val TEAM_PSEUDO_USER = 1 shl 10

    /** Bug Hunter Level 2 */
    const val BUG_HUNTER_LEVEL_2 = 1 shl 14

    /** Verified Bot */
    const val VERIFIED_BOT = 1 shl 16

    /** Early Verified Bot Developer */
    const val VERIFIED_DEVELOPER = 1 shl 17

    /** Moderator Programs Alumni */
    const val CERTIFIED_MODERATOR = 1 shl 18

    /** Bot uses only [HTTP interactions](https://discord.com/developers/docs/interactions/receiving-and-responding#receiving-an-interaction) and is shown in the online member list */
    const val BOT_HTTP_INTERACTIONS = 1 shl 19

    /** User is an [Active Developer](https://support-dev.discord.com/hc/articles/10113997751447) */
    const val ACTIVE_DEVELOPER = 1 shl 22
}
