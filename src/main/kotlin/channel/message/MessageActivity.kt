package cloud.drakon.discordkt.channel.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property type type of message activity
 * @property partyId party_id from a Rich Presence event
 */
@Serializable class MessageActivity(
    val type: Byte,
    @SerialName("party_id") val partyId: String? = null,
)
