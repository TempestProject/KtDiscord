package cloud.drakon.ktdiscord.channel.message

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property messageId id of the originating message
 * @property channelId id of the originating message's channel
 * @property guildId id of the originating message's guild
 * @property failIfNotExists when sending, whether to error if the referenced message doesn't exist instead of sending as a normal (non-reply) message, default true
 */
@JsExport @Serializable class MessageReference(
    @SerialName("message_id") val messageId: String? = null,
    @SerialName("channel_id") val channelId: String? = null,
    @SerialName("guild_id") val guildId: String? = null,
    @SerialName("fail_if_not_exists") val failIfNotExists: String? = null,
)
