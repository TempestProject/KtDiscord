package cloud.drakon.tempest.webhook

import cloud.drakon.tempest.components.Components
import cloud.drakon.tempest.util.Embed

class ExecuteWebhook(
    val content: String?,
    val username: String?,
    val avatar_url: String?,
    val tts: Boolean?,
    val embeds: Array<Embed>?,
    val allowed_mentions: AllowedMention,
    val components: Components?,
    val files: String?,
    val payload_json: String?,
    val attachments: String?,
    val flags: Short?,
    val thread_name: String?
)
