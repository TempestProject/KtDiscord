package cloud.drakon.discordkt.channel.embed

import kotlinx.serialization.Serializable

/**
 * @property name name of provider
 * @property url url of provider
 */
@Serializable class EmbedProvider(val name: String? = null, val url: String? = null)
