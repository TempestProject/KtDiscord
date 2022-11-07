package cloud.drakon.tempest.webhook

import cloud.drakon.tempest.components.Component
import cloud.drakon.tempest.util.Embed

class ExecuteWebhook(
    val content: String?,
    val username: String?,
    val avatar_url: String?,
    val tts: Boolean?,
    val embeds: Array<Embed>?,
    val allowed_mentions: AllowedMention,
    val components: Array<Component>?,
    val files: String? = TODO(),
    val payload_json: String? = TODO(),
    val attachments: String? = TODO(),
    val flags: Short?,
    val thread_name: String?
)
