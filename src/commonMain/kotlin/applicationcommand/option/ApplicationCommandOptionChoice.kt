package cloud.drakon.ktdiscord.applicationcommand.option

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * If you specify `choices` for an option, they are the **only** valid values for a user to pick
 * @property name 1-100 character choice name
 * @property nameLocalizations Localization dictionary for the `name` field. Values follow the same restrictions as `name`
 * @property value Value for the choice, up to 100 characters if string
 */
@JsExport @Serializable class ApplicationCommandOptionChoice(
    val name: String,
    @SerialName("name_localizations") val nameLocalizations: Map<String, String>,
    val value: String,
)
