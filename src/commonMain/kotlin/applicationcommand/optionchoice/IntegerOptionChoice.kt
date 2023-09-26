@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.applicationcommand.optionchoice

import cloud.drakon.ktdiscord.Locale
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.Serializable

@JsExport @Serializable class IntegerOptionChoice(
    override val name: String,
    override val nameLocalizations: Map<Locale, String>?,
    val value: Long,
): OptionChoice
