package cloud.drakon.ktdiscord.applicationcommand.optionchoice

import cloud.drakon.ktdiscord.reference.Locale
import kotlinx.serialization.SerialName

@Deprecated("Will be replaced with a single `OptionChoice` class when union types are available in Kotlin.")

sealed interface OptionChoice {
    val name: String
    @SerialName("name_localizations") val nameLocalizations: Map<Locale, String>?
}
