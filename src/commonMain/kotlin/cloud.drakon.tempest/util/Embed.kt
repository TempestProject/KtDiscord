package cloud.drakon.tempest.util

/**
 * @property title Title of embed.
 * @property type Type of embed.
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
class Embed(
    val title: String?,
    val type: String?,
    val description: String?,
    val url: String?,
    val timestamp: String?,
    val color: Short?,
    val footer: EmbedFooter?,
    val image: EmbedMedia?,
    val thumbnail: EmbedMedia?,
    val video: EmbedMedia?,
    val provider: EmbedProvider?,
    val author: EmbedMedia?,
    val fields: Array<EmbedField>?,
)

/**
 * @property text Footer text.
 * @property icon_url URL of footer icon (only supports HTTP(S) and attachments).
 * @property proxy_icon_url A proxied URL of footer icon.
 */
class EmbedFooter(val text: String, val icon_url: String?, val proxy_icon_url: String?)

/**
 * @property url Source URL of media (only supports HTTP(S) and attachments).
 * @property proxy_url A proxied URL of the media.
 * @property height Height of media.
 * @property width Width of media.
 */
class EmbedMedia(
    val url: String,
    val proxy_url: String?,
    val height: Short?,
    val width: Short?,
)

/**
 * @property name Name of provider.
 * @property name url URL of provider.
 */
class EmbedProvider(val name: String?, val url: String?)

/**
 * @property name Name of the field.
 * @property value Value of the field.
 * @property inline Whether or not this field should display inline.
 */
class EmbedField(val name: String, val value: String, val inline: Boolean?)
