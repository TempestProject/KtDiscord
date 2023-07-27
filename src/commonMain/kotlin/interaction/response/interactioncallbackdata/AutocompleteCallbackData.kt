package cloud.drakon.ktdiscord.interaction.response.interactioncallbackdata

import cloud.drakon.ktdiscord.applicationcommand.option.ApplicationCommandOptionChoice
import kotlinx.serialization.Serializable

/**
 * @property choices autocomplete choices (max of 25 choices)
 */
@Serializable
class AutocompleteCallbackData(val choices: List<ApplicationCommandOptionChoice>):
    InteractionCallbackData
