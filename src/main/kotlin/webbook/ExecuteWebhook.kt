package cloud.drakon.discordkt.webbook

import cloud.drakon.discordkt.channel.Attachment
import cloud.drakon.discordkt.channel.allowedmentions.AllowedMentions
import cloud.drakon.discordkt.channel.embed.Embed
import cloud.drakon.discordkt.components.Component
import cloud.drakon.discordkt.file.File
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable class ExecuteWebhook(
    val content: String? = null,
    val tts: Boolean? = null,
    val embeds: Array<Embed>? = null,
    @SerialName("allowed_mentions") val allowedMentions: AllowedMentions? = null,
    val components: Array<Component>? = null,
    @Transient override val files: Array<File>? = null,
    @SerialName("payload_json") val payloadJson: String? = null,
    val attachments: Array<Attachment>? = null,
    val flags: Byte? = null,
    @SerialName("thread_name") val threadName: String? = null,
): Webhook
