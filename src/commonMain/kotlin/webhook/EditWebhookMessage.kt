package cloud.drakon.tempest.webhook

import cloud.drakon.tempest.channel.Embed
import cloud.drakon.tempest.components.Component

/**
 * @property content The message contents (up to 2000 characters).
 * @property embeds Embedded rich content.
 * @property allowed_mentions Allowed mentions for the message.
 * @property components The components to include with the message.
 */
class EditWebhookMessage(
    val content: String?,
    val embeds: Array<Embed>?,
    val allowed_mentions: AllowedMention?,
    val components: Array<Component>?,
)
