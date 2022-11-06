package cloud.drakon.tempest.webhook

import cloud.drakon.tempest.components.Components
import cloud.drakon.tempest.util.Embed

class EditWebhookMessage(
    val content: String?,
    val embeds: Array<Embed>?,
    val allowed_mentions: AllowedMention?,
    val components: Array<Components>?,
    val files: String? = TODO(),
    val payload_json: String? = TODO(),
    val attachments: Array<String>? = TODO()
)
