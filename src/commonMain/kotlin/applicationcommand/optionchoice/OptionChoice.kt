@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.applicationcommand.optionchoice

import cloud.drakon.ktdiscord.Locale
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName

@JsExport sealed interface OptionChoice {
    val name: String
    @SerialName("name_localizations") val nameLocalizations: Map<Locale, String>?
}
