package cloud.drakon.discordkt.interaction

import cloud.drakon.discordkt.components.Component
import kotlinx.serialization.Serializable

/**
 * @property custom_id the `custom_id` of the modal
 * @property components the values submitted by the user
 */
@Serializable class ModalSubmitData(
    val custom_id: String,
    val components: Array<Component>,
): InteractionData
