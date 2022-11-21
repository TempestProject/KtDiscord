package interaction.response.interactioncallbackdata

import components.Component
import kotlinx.serialization.Serializable

/**
 * @property custom_id a developer-defined identifier for the component, max 100 characters
 * @property title the title of the popup modal, max 45 characters
 * @property components between 1 and 5 (inclusive) components that make up the modal
 */
@Serializable class ModalCallbackData(
    val custom_id: String,
    val title: String,
    val components: Array<Component>,
): InteractionCallbackData
