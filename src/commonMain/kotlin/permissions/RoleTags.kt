package cloud.drakon.ktdiscord.permissions

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property botId the id of the bot this role belongs to
 * @property integrationId the id of the integration this role belongs to
 * @property premiumSubscriber whether this is the guild's premium subscriber role
 * @property subscriptionListingId the id of this role's subscription sku and listing
 * @property availableForPurchase whether this role is available for purchase
 * @property guildConnections whether this role is a guild's linked role
 */
@JsExport @Serializable class RoleTags(
    @SerialName("bot_id") val botId: String? = null,
    @SerialName("integration_id") val integrationId: String? = null,
    @SerialName("premium_subscriber") val premiumSubscriber: Boolean? = false,
    @SerialName("subscription_listing_id") val subscriptionListingId: String? = null,
    @SerialName("available_for_purchase") val availableForPurchase: Boolean? = false,
    @SerialName("guild_connections") val guildConnections: Boolean? = false,
)
