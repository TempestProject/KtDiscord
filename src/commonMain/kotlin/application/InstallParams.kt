package cloud.drakon.ktdiscord.application

import kotlin.js.JsExport
import kotlinx.serialization.Serializable

/**
 * @property scopes the scopes to add the application to the server with
 * @property permissions the permissions to request for the bot role
 */
@JsExport @Serializable class InstallParams(
    val scopes: Array<String>,
    val permissions: String,
)
