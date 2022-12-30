package cloud.drakon.discordkt.webbook

import cloud.drakon.discordkt.channel.Attachment
import cloud.drakon.discordkt.channel.allowedmentions.AllowedMentions
import cloud.drakon.discordkt.channel.embed.Embed
import cloud.drakon.discordkt.components.Component
import cloud.drakon.discordkt.file.File
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable class EditWebhookMessage(
    val content: String? = null,
    val embeds: Array<Embed>? = null,
    val allowed_mentions: AllowedMentions? = null,
    val components: Array<Component>? = null,
    @Transient override val files: Array<File>? = null,
    val payload_json: String? = null,
    val attachments: Array<Attachment>? = null,
): Webhook
