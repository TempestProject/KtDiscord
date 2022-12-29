package cloud.drakon.tempest.webbook

import cloud.drakon.tempest.File
import cloud.drakon.tempest.channel.Attachment
import cloud.drakon.tempest.channel.allowedmentions.AllowedMentions
import cloud.drakon.tempest.channel.embed.Embed
import cloud.drakon.tempest.components.Component

class ExecuteWebhook(
    val content: String? = null,
    val tts: Boolean? = null,
    val embeds: Array<Embed>? = null,
    val allowed_mentions: AllowedMentions? = null,
    val components: Array<Component>? = null,
    val files: Array<File>? = null,
    val payload_json: String? = null,
    val attachments: Array<Attachment>? = null,
    val flags: Byte? = null,
    val thread_name: String? = null,
)
