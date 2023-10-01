@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.component

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * [Button]s come in a variety of styles to convey different types of actions. These styles also define what fields are valid for a [Button].
 *
 * * Non-link buttons must have a `customId`, and cannot have a `url`.
 * * Link buttons must have a `url`, and cannot have a `customId`.
 * * Link buttons do not send an [Interaction] to your app when clicked`
 */
@JsExport @Serializable
enum class ButtonStyle {
    /** Blurple */
    @SerialName("1") PRIMARY,

    /** Grey */
    @SerialName("2") SECONDARY,

    /** Green */
    @SerialName("3") SUCCESS,

    /** Red */
    @SerialName("4")
    DANGER,

    /** Grey, navigates to a URL */
    @SerialName("5") LINK,
}
