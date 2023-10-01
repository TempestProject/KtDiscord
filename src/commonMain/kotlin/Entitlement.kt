@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord

import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
class Entitlement(val id: Snowflake)
