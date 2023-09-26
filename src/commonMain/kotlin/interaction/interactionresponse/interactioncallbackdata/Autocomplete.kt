package cloud.drakon.ktdiscord.interaction.interactionresponse.interactioncallbackdata

import cloud.drakon.ktdiscord.applicationcommand.optionchoice.OptionChoice
import kotlinx.serialization.Serializable

@Serializable class Autocomplete(val choices: Array<OptionChoice>)
