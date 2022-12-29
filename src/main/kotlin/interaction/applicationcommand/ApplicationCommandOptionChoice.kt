package cloud.drakon.tempest.interaction.applicationcommand

import kotlinx.serialization.Serializable

/**
 * @property name 1-100 character choice name
 * @property name_localizations Localization dictionary for the `name` field. Values follow the same restrictions as `name`
 * @property value Value for the choice, up to 100 characters if string
 */
@Serializable class ApplicationCommandOptionChoice(
    val name: String,
    val name_localizations: Map<String, String>,
    val value: String,
)
