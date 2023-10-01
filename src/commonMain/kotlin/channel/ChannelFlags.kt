@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport
object ChannelFlags {
    /** This thread is pinned to the top of its parent [ChannelType.GUILD_FORUM] or [ChannelType.GUILD_MEDIA] channel. */
    const val PINNED = 1 shl 1

    /** Whether a tag is required to be specified when creating a thread in a [ChannelType.GUILD_FORUM] or a [ChannelType.GUILD_MEDIA] channel. Tags are specified in the `appliedTags` field. */
    const val REQUIRE_TAG = 1 shl 4

    /** When set hides the embedded media download options. Available only for media channels. */
    const val HIDE_MEDIA_DOWNLOAD_OPTIONS = 1 shl 15
}
