package cloud.drakon.ktdiscord.interaction

import cloud.drakon.ktdiscord.components.Component
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property customId the `custom_id` of the modal
 * @property components the values submitted by the user
 */
@Serializable class ModalSubmitData(
    @SerialName("custom_id") val customId: String,
    val components: Array<Component>,
): InteractionData
