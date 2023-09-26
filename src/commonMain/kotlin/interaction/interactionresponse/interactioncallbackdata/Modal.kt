@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.interactionresponse.interactioncallbackdata

import cloud.drakon.ktdiscord.interaction.component.TextInput
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable class Modal(
    /** A developer-defined identifier for the modal, max 100 characters */
    @SerialName("custom_id") val customId: String,

    /** The title of the popup modal, max 45 characters */
    val title: String,

    /** Between 1 and 5 (inclusive) components that make up the modal. Support for components in modals is currently limited to [TextInput]. */
    val components: Array<TextInput>,
): InteractionCallbackData
