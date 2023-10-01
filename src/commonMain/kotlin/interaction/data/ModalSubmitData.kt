@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.data

import cloud.drakon.ktdiscord.component.ActionRow
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property customId The [customId] of the modal.
 * @property components The values submitted by the user.
 */
@JsExport @Serializable
data class ModalSubmitData(
    @SerialName("custom_id") val customId: String,
    val components: Array<ActionRow>,
) : InteractionData
