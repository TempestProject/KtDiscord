@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.permissions

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable class RoleTag(
    @SerialName("bot_id") val botId: String? = null,
    @SerialName("integration_id") val integrationId: String? = null,

    //TODO Tags with type null represent booleans. They will be present and set to null if they are "true", and will be not present if they are "false".
    //@SerialName("premium_subscriber") val premiumSubscriber: Boolean? = null,

    @SerialName("subscription_listing_id") val subscriptionListingId: String? = null,

    //TODO
    //@SerialName("available_for_purchase") val availableForPurchase: Boolean? = null,
    //@SerialName("guild_connections") val guildConnections: Boolean? = null,
)
