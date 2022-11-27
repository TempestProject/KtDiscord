package cloud.drakon.tempest.interaction.response.interactioncallbackdata

import cloud.drakon.tempest.channel.Attachment
import cloud.drakon.tempest.channel.allowedmentions.AllowedMentions
import cloud.drakon.tempest.channel.embed.Embed
import cloud.drakon.tempest.components.Component
import kotlinx.serialization.Serializable

/**
 * @property tts is the response TTS
 * @property content message content
 * @property embeds supports up to 10 embeds
 * @property allowed_mentions allowed mentions object
 * @property flags message flags combined as a bitfield (only `SUPPRESS_EMBEDS` and `EPHEMERAL` can be set)
 * @property components message components
 * @property attachments attachment objects with filename and description
 */
@Serializable class MessageCallbackData(
    val tts: Boolean? = null,
    val content: String? = null,
    val embeds: Array<Embed>? = null,
    val allowed_mentions: AllowedMentions? = null,
    val flags: Short? = null,
    val components: Array<Component>? = null,
    val attachments: Array<Attachment>? = null,
): InteractionCallbackData
