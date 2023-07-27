package cloud.drakon.ktdiscord.webhook

import cloud.drakon.ktdiscord.channel.Attachment
import cloud.drakon.ktdiscord.channel.allowedmentions.AllowedMentions
import cloud.drakon.ktdiscord.channel.embed.Embed
import cloud.drakon.ktdiscord.components.Component
import cloud.drakon.ktdiscord.file.File
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable class ExecuteWebhook(
    val content: String? = null,
    val tts: Boolean? = null,
    val embeds: List<Embed>? = null,
    @SerialName("allowed_mentions") val allowedMentions: AllowedMentions? = null,
    val components: List<Component>? = null,
    @Transient override val files: List<File>? = null,
    @SerialName("payload_json") val payloadJson: String? = null,
    val attachments: List<Attachment>? = null,
    val flags: Byte? = null,
    @SerialName("thread_name") val threadName: String? = null,
): Webhook
