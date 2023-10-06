@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.data

import cloud.drakon.ktdiscord.Snowflake
import cloud.drakon.ktdiscord.applicationcommand.ApplicationCommandType
import cloud.drakon.ktdiscord.interaction.InteractionType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * Sent in [InteractionType.APPLICATION_COMMAND] and [InteractionType.APPLICATION_COMMAND_AUTOCOMPLETE] interactions.
 * @property id The ID of the invoked command.
 * @property name The name of the invoked command.
 * @property type The type of the invoked command.
 * @property resolved Converted [User]s + [Role]s + [Channel]s + [Attachment]s.
 * @property options The params + values from the user. This can be partial when in response to [InteractionType.APPLICATION_COMMAND_AUTOCOMPLETE]. The option the user is currently typing will be sent with a `focused = true` field and options the user has already filled will also be sent but without the `focused` field.
 * @property guildId The ID of the guild the command is registered to.
 * @property targetId ID of the [User] or [Message] targeted by a [ApplicationCommandType.USER] or [ApplicationCommandType.MESSAGE] command.
 */
@JsExport @Serializable
data class ApplicationCommandData(
    val id: Snowflake,
    val name: String,
    val type: ApplicationCommandType,
    val resolved: ResolvedData? = null,
    val options: Array<ApplicationCommandInteractionDataOption>? = null,
    @SerialName("guild_id") val guildId: Snowflake? = null,
    @SerialName("target_id") val targetId: Snowflake? = null,
) : InteractionData
