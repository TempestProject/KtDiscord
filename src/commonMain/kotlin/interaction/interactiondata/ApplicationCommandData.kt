package cloud.drakon.ktdiscord.interaction.interactiondata

import cloud.drakon.ktdiscord.interaction.ResolvedData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property id the `ID` of the invoked command
 * @property name the `name` of the invoked command
 * @property type the `type` of the invoked command
 * @property resolved converted users + roles + channels + attachments
 * @property options the params + values from the user
 * @property guildId the id of the guild the command is registered to
 * @property targetId id of the user or message targeted by a user or message command
 */
@Serializable class ApplicationCommandData(
    val id: String,
    val name: String,
    val type: Int,
    val resolved: ResolvedData? = null,
    val options: List<ApplicationCommandInteractionDataOption>? = null,
    @SerialName("guild_id") val guildId: String? = null,
    @SerialName("target_id") val targetId: String? = null,
): InteractionData
