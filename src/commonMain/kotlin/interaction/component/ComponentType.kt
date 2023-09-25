@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.interaction.component

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable enum class ComponentType {
    /** Container for other components */
    @SerialName("1") ACTION_ROW,

    /** Button object */
    @SerialName("2") BUTTON,

    /** Select menu for picking from defined text options */
    @SerialName("3") STRING_SELECT,

    /** Text input object */
    @SerialName("4") TEXT_INPUT,

    /** Select menu for users */
    @SerialName("5") USER_SELECT,

    /** Select menu for roles */
    @SerialName("6") ROLE_SELECT,

    /** Select menu for mentionables (users *and* roles) */
    @SerialName("7") MENTIONABLE_SELECT,

    /** Select menu for channels */
    @SerialName("8") CHANNEL_SELECT
}
