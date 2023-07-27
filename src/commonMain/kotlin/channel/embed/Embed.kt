package cloud.drakon.ktdiscord.channel.embed

import kotlinx.serialization.Serializable

/**
 * @property title title of embed
 * @property type type of embed (always "rich" for webhook embeds)
 * @property description description of embed
 * @property url url of embed
 * @property timestamp timestamp of embed content
 * @property color color code of the embed
 * @property footer footer information
 * @property image image information
 * @property thumbnail thumbnail information
 * @property video video information
 * @property provider provider information
 * @property author author information
 * @property fields fields information
 */
@Serializable class Embed(
    val title: String? = null,
    val type: String? = null,
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
    val fields: List<EmbedField>? = null,
)
