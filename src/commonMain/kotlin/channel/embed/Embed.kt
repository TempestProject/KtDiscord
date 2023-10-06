@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.embed

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property title Title of embed.
 * @property type type of embed (always [EmbedType.RICH] for webhook embeds).
 * @property description Description of embed.
 * @property url URL of embed.
 * @property timestamp Timestamp of embed content.
 * @property color Color code of the embed.
 * @property footer Footer information.
 * @property image Image information.
 * @property thumbnail Thumbnail information.
 * @property video Video information.
 * @property provider Provider information.
 * @property author Author information.
 * @property fields Fields information.
 */
@JsExport @Serializable
data class Embed(
    val title: String? = null,
    val type: EmbedType? = null,
    val description: String? = null,
    val url: String? = null,
    val timestamp: String? = null,
    val color: Int? = null,
    val footer: EmbedFooter? = null,
    val image: EmbedImage? = null,
    val thumbnail: EmbedThumbnail? = null,
    val video: EmbedVideo? = null,
    val provider: EmbedProvider? = null,
    val author: EmbedAuthor? = null,
    val fields: Array<EmbedField>? = null,
)
