package cloud.drakon.ktdiscord.webhook

import cloud.drakon.ktdiscord.channel.Attachment
import cloud.drakon.ktdiscord.channel.allowedmentions.AllowedMentions
import cloud.drakon.ktdiscord.channel.embed.Embed
import cloud.drakon.ktdiscord.components.Component
import cloud.drakon.ktdiscord.file.File
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@JsExport @Serializable class ExecuteWebhook(
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
