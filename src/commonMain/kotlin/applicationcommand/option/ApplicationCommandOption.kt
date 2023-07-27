package cloud.drakon.ktdiscord.applicationcommand.option

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property type Type of option
 * @property name 1-32 character name
 * @property nameLocalizations Localization dictionary for the `name` field. Values follow the same restrictions as `name`
 * @property description 1-100 character description
 * @property descriptionLocalizations Localization dictionary for the `description` field. Values follow the same restrictions as `description`
 * @property required If the parameter is required or optional--default `false`
 * @property choices Choices for `STRING`, `INTEGER`, and `NUMBER` types for the user to pick from, max 25
 * @property options If the option is a subcommand or subcommand group type, these nested options will be the parameters
 * @property channelTypes If the option is a channel type, the channels shown will be restricted to these types
 * @property minValue If the option is an `INTEGER` or `NUMBER` type, the minimum value permitted
 * @property maxValue If the option is an `INTEGER` or `NUMBER` type, the maximum value permitted
 * @property minLength For option type `STRING`, the minimum allowed length (minimum of `0`, maximum of `6000`)
 * @property maxLength For option type `STRING`, the maximum allowed length (minimum of `1`, maximum of `6000`)
 * @property autocomplete If autocomplete interactions are enabled for this `STRING`, `INTEGER`, or `NUMBER` type option
 */
@Serializable class ApplicationCommandOption(
    val type: Byte,
    val name: String,
    @SerialName("name_localizations") val nameLocalizations: Map<String, String>,
    val description: String,
    @SerialName("description_localizations")
    val descriptionLocalizations: Map<String, String>,
    val required: Boolean? = null,
    val choices: List<ApplicationCommandOptionChoice>? = null,
    val options: List<ApplicationCommandOption>? = null,
    @SerialName("channel_types") val channelTypes: ByteArray? = null,
    @SerialName("min_value") val minValue: Double? = null,
    @SerialName("max_value") val maxValue: Double? = null,
    @SerialName("min_length") val minLength: Int? = null,
    @SerialName("max_length") val maxLength: Int? = null,
    val autocomplete: Boolean? = null,
)
