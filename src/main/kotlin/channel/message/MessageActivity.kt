package cloud.drakon.discordkt.channel.message

import kotlinx.serialization.Serializable

/**
 * @property type type of message activity
 * @property party_id party_id from a Rich Presence event
 */
@Serializable class MessageActivity(val type: Byte, val party_id: String? = null)
