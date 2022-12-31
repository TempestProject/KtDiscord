package cloud.drakon.ktdiscord.interaction.applicationcommand

import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property name 1-100 character choice name
 * @property nameLocalizations Localization dictionary for the `name` field. Values follow the same restrictions as `name`
 * @property value Value for the choice, up to 100 characters if string
 */
@JsExport @Serializable class ApplicationCommandOptionChoice(
    val name: String,
    @SerialName("name_localizations") val nameLocalizations: Map<String, String>,
    val value: String,
)
