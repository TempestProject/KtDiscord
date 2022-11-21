package cloud.drakon.tempest.interaction

import cloud.drakon.tempest.components.Component
import kotlinx.serialization.Serializable

/**
 * @property custom_id the `custom_id` of the modal
 * @property components the values submitted by the user
 */
@Serializable class ModalSubmitData(
    val custom_id: String,
    val components: Array<Component>,
)
