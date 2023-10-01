@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.permissions

import cloud.drakon.ktdiscord.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Tags with type `null` represent booleans. They will be present and set to `null` if they are `true`, and will be not present if they are `false`.
 * @property botId The ID of the bot this [Role] belongs to.
 * @property integrationId The ID of the integration this [Role] belongs to.
 * @property subscriptionListingId The ID of this [Role]'s subscription SKU and listing.
 */
@JsExport @Serializable
data class RoleTags(
    @SerialName("bot_id") val botId: Snowflake? = null,
    @SerialName("integration_id") val integrationId: Snowflake? = null,
    //TODO @SerialName("premium_subscriber") val premiumSubscriber: Boolean? = null,
    @SerialName("subscription_listing_id") val subscriptionListingId: Snowflake? = null,
    //TODO @SerialName("available_for_purchase") val availableForPurchase: Boolean? = null,
    //TODO @SerialName("guild_connections") val guildConnections: Boolean? = null,
)
