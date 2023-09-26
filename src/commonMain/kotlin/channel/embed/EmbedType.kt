package cloud.drakon.ktdiscord.channel.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Embed types are "loosely defined" and, for the most part, are not used by the client for rendering. Embed attributes power what is rendered.
 */
@Deprecated("Embed attributes power what is rendered. Embed types should be considered deprecated and might be removed in a future API version.")

@Serializable enum class EmbedType {
    /** Generic embed rendered from embed attributes */
    @SerialName("rich") RICH,

    /** Image embed */
    @SerialName("image") IMAGE,

    /** Video embed */
    @SerialName("video") VIDEO,

    /** Animated GIF image embed rendered as a video embed */
    @SerialName("gifv") GIFV,

    /** Article embed */
    @SerialName("article") ARTICLE,

    /** Link embed */
    @SerialName("link") LINK
}
