@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.interactionresponse.interactioncallbackdata

import cloud.drakon.ktdiscord.applicationcommand.optionchoice.OptionChoice
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable class Autocomplete(val choices: Array<OptionChoice>)
