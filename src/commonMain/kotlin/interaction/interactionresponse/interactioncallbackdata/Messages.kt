@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.interactionresponse.interactioncallbackdata

import cloud.drakon.ktdiscord.channel.allowedmentions.AllowedMentions
import cloud.drakon.ktdiscord.channel.embed.Embed
import cloud.drakon.ktdiscord.interaction.component.ActionRow
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable class Messages(
    val tts: Boolean? = null,
    val content: String? = null,
    val embeds: Array<Embed>? = null,
    @SerialName("allowed_mentions") val allowedMentions: AllowedMentions? = null,
    val flags: Int? = null,
    val components: Array<ActionRow>? = null,
): InteractionCallbackData
