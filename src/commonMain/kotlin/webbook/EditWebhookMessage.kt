package cloud.drakon.tempest.webbook

import cloud.drakon.tempest.channel.Attachment
import cloud.drakon.tempest.channel.allowedmentions.AllowedMentions
import cloud.drakon.tempest.channel.embed.Embed
import cloud.drakon.tempest.components.Component
import kotlinx.serialization.Serializable

@Serializable class EditWebhookMessage(
    val content: String? = null,
    val embeds: Array<Embed>? = null,
    val allowed_mentions: AllowedMentions? = null,
    val components: Array<Component>? = null,
    val payload_json: String? = null,
    val attachments: Array<Attachment>? = null
)
