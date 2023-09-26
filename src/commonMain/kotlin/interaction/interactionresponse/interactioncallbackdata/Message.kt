package cloud.drakon.ktdiscord.interaction.interactionresponse.interactioncallbackdata

import cloud.drakon.ktdiscord.channel.Attachment
import cloud.drakon.ktdiscord.channel.allowedmentions.AllowedMentions
import cloud.drakon.ktdiscord.channel.embed.Embed
import cloud.drakon.ktdiscord.interaction.component.ActionRow
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable class Message(
    val tts: Boolean? = null,
    val content: String? = null,
    val embeds: Array<Embed>? = null,
    @SerialName("allowed_mentions") val allowedMentions: AllowedMentions? = null,
    val flags: Int? = null,
    val components: Array<ActionRow>? = null,
    val attachments: Array<Attachment>? = null,
): InteractionCallbackData
