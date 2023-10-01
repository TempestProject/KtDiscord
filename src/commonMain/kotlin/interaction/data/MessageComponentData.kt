@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.data

import cloud.drakon.ktdiscord.component.ComponentType
import cloud.drakon.ktdiscord.component.SelectOption
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property customId The `customId` of the [Component].
 * @property componentType The type of the [Component].
 * @property values Values the user selected in a [SelectMenu] [Component]. This is always present for [SelectMenu] [Component]s.
 */
@JsExport @Serializable
data class MessageComponentData(
    @SerialName("custom_id") val customId: String,
    @SerialName("component_type") val componentType: ComponentType,
    val values: Array<SelectOption>? = null,
) : InteractionData
