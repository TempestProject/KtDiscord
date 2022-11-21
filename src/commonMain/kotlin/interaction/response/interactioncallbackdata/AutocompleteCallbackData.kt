package interaction.response.interactioncallbackdata

import interaction.applicationcommand.ApplicationCommandOptionChoice
import kotlinx.serialization.Serializable

/**
 * @property choices autocomplete choices (max of 25 choices)
 */
@Serializable
class AutocompleteCallbackData(val choices: Array<ApplicationCommandOptionChoice>):
    InteractionCallbackData
