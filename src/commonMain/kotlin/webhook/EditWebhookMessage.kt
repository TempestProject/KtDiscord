package cloud.drakon.tempest.webhook

import cloud.drakon.tempest.components.Component
import cloud.drakon.tempest.util.Embed

/**
 * @property content The message contents (up to 2000 characters).
 * @property embeds Embedded rich content.
 * @property allowed_mentions Allowed mentions for the message.
 * @property components The components to include with the message.
 * @property files The contents of the file being sent/edited.
 * @property payload_json JSON encoded body of non-file params (multipart/form-data only).
 * @property attachments Attached files to keep and possible descriptions for new files.
 */
class EditWebhookMessage(
    val content: String?,
    val embeds: Array<Embed>?,
    val allowed_mentions: AllowedMention?,
    val components: Array<Component>?,
    val files: String? = TODO(),
    val payload_json: String? = TODO(),
    val attachments: Array<String>? = TODO(),
)
