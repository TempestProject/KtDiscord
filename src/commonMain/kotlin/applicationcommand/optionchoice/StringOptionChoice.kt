@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.applicationcommand.optionchoice

import cloud.drakon.ktdiscord.Locale
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable class StringOptionChoice(
    override val name: String,
    override val nameLocalizations: Map<Locale, String>?,
    val value: String,
): OptionChoice
