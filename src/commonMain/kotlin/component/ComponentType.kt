@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.component

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class ComponentType {
    /** Container for other components. */
    @SerialName("1") ACTION_ROW,

    /** [Button] object. */
    @SerialName("2") BUTTON,

    /** [SelectMenu] for picking from defined text options. */
    @SerialName("3") STRING_SELECT,

    /** Text input object. */
    @SerialName("4") TEXT_INPUT,

    /** [SelectMenu] for [User]s. */
    @SerialName("5") USER_SELECT,

    /** [SelectMenu] for [Role]s. */
    @SerialName("6") ROLE_SELECT,

    /** [SelectMenu] for mentionables ([User]s and [Role]s) */
    @SerialName("7") MENTIONABLE_SELECT,

    /** [SelectMenu] for [Channel]s. */
    @SerialName("8") CHANNEL_SELECT,
}
