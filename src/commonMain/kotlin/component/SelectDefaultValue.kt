@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.component

import cloud.drakon.ktdiscord.Snowflake
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * @property id ID of a [User], [Role], or [Channel].
 * @property type Type of value that [id] represents. Either [SelectDefaultValueType.USER], [SelectDefaultValueType.ROLE], or [SelectDefaultValueType.CHANNEL].
 */
@JsExport @Serializable
class SelectDefaultValue(val id: Snowflake, val type: SelectDefaultValueType)
