@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.component

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * An Action Row is a non-interactive container [Component] for other types of components. It has a sub-array of `components` of other types.
 *
 * * You can have up to 5 [ActionRow]s per [Message].
 * * An [ActionRow] cannot contain another [ActionRow].
 */
@JsExport @Serializable
class ActionRow(val components: Array<Component>? = null) {
    val type = ComponentType.ACTION_ROW
}
