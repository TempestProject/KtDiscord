@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.entitlement

import cloud.drakon.ktdiscord.Snowflake
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Entitlements in Discord represent that a user or guild has access to a premium offering in your application.
 * @property id ID of the entitlement.
 * @property skuId ID of the SKU.
 * @property userId ID of the [User] that is granted access to the entitlement's SKU.
 * @property guildId ID of the guild that is granted access to the entitlement's SKU.
 * @property applicationId ID of the parent application.
 * @property type Type of entitlement.
 * @property consumed Not applicable for App Subscriptions. Subscriptions are not consumed and will be `false`.
 * @property startsAt Start date at which the entitlement is valid. Not present when using test entitlements.
 * @property endsAt Date at which the entitlement is no longer valid. Not present when using test entitlements.
 */
@JsExport @Serializable
data class Entitlement(
    val id: Snowflake,
    @SerialName("sku_id") val skuId: Snowflake,
    @SerialName("user_id") val userId: Snowflake? = null,
    @SerialName("guild_id") val guildId: Snowflake? = null,
    @SerialName("application_id") val applicationId: Snowflake,
    val type: EntitlementType,
    val consumed: Boolean,
    @SerialName("starts_at") val startsAt: String? = null,
    @SerialName("ends_at") val endsAt: String? = null,
)
