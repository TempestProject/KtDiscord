@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.component.button

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Buttons come in a variety of styles to convey different types of actions. These styles also define what fields are valid for a button.
 *
 * * Non-link buttons must have a `custom_id`, and cannot have a URL
 * * Link buttons must have a URL, and cannot have a `custom_id`
 * * Link buttons do not send an [interaction](https://discord.com/developers/docs/interactions/receiving-and-responding#interaction-object) to your app when clicked
 */
@JsExport @Serializable enum class ButtonStyle {
    /** Blurple */
    @SerialName("1") PRIMARY,

    /** Grey */
    @SerialName("2") SECONDARY,

    /** Green */
    @SerialName("3") SUCCESS,

    /** Red */
    @SerialName("4") DANGER,

    /** Grey, navigates to a URL */
    @SerialName("5") LINK
}
