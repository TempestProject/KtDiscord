package cloud.drakon.ktdiscord.interaction.response.interactioncallbackdata

import cloud.drakon.ktdiscord.applicationcommand.option.ApplicationCommandOptionChoice
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * @property choices autocomplete choices (max of 25 choices)
 */
@JsExport @Serializable
class AutocompleteCallbackData(val choices: Array<ApplicationCommandOptionChoice>):
    InteractionCallbackData
