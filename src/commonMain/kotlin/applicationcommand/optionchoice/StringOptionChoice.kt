package cloud.drakon.ktdiscord.applicationcommand.optionchoice

import cloud.drakon.ktdiscord.reference.Locale
import kotlinx.serialization.Serializable

@Deprecated("Will be replaced with a single `OptionChoice` class when union types are available in Kotlin.")

@Serializable class StringOptionChoice(
    override val name: String,
    override val nameLocalizations: Map<Locale, String>?,
    val value: String,
): OptionChoice
