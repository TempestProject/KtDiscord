package cloud.drakon.discordkt.interaction.response.interactioncallbackdata

import cloud.drakon.discordkt.channel.Attachment
import cloud.drakon.discordkt.channel.allowedmentions.AllowedMentions
import cloud.drakon.discordkt.channel.embed.Embed
import cloud.drakon.discordkt.components.Component
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property tts is the response TTS
 * @property content message content
 * @property embeds supports up to 10 embeds
 * @property allowedMentions allowed mentions object
 * @property flags message flags combined as a bitfield (only `SUPPRESS_EMBEDS` and `EPHEMERAL` can be set)
 * @property components message components
 * @property attachments attachment objects with filename and description
 */
@Serializable class MessageCallbackData(
    val tts: Boolean? = null,
    val content: String? = null,
    val embeds: Array<Embed>? = null,
    @SerialName("allowed_mentions") val allowedMentions: AllowedMentions? = null,
    val flags: Short? = null,
    val components: Array<Component>? = null,
    val attachments: Array<Attachment>? = null,
): InteractionCallbackData
