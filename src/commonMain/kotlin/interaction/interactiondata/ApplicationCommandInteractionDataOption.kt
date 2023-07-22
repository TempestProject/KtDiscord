package cloud.drakon.ktdiscord.interaction.interactiondata

import kotlinx.serialization.Serializable

/**
 * All options have names, and an option can either be a parameter and input value--in which case value will be set--or it can denote a subcommand or group--in which case it will contain a top-level key and another array of options.
 *
 * `value` and `options` are mutually exclusive.
 * @property name Name of the parameter
 * @property type Value of application command option type
 * @property value Value of the option resulting from user input
 * @property options Present if this option is a group or subcommand
 * @property focused `true` if this option is the currently focused option for autocomplete
 */
@Serializable class ApplicationCommandInteractionDataOption(
    val name: String,
    val type: Byte,
    val value: String? = null,
    val options: Array<ApplicationCommandInteractionDataOption>? = null,
    val focused: Boolean? = null,
)
