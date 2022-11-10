package cloud.drakon.tempest.webhook

import cloud.drakon.tempest.channel.Embed
import cloud.drakon.tempest.channel.Flags
import cloud.drakon.tempest.components.Component

/**
 * @property content The message contents (up to 2000 characters).
 * @property tts True if this is a TTS message.
 * @property embeds Embedded rich content.
 * @property allowed_mentions Allowed mentions for the message.
 * @property components The components to include with the message.
 * @property files The contents of the file being sent.
 * @property payload_json JSON encoded body of non-file params.
 * @property attachments Attachment objects with filename and description.
 * @property flags Message flags combined as a bitfield.
 * @property thread_name Name of thread to create (requires the webhook channel to be a forum channel).
 */
class ExecuteWebhook(
    val content: String?,
    val tts: Boolean?,
    val embeds: Array<Embed>?,
    val allowed_mentions: AllowedMention,
    val components: Array<Component>?,
    val files: String? = TODO(),
    val payload_json: String? = TODO(),
    val attachments: String? = TODO(),
    val flags: Enum<Flags>?,
    val thread_name: String?,
)
