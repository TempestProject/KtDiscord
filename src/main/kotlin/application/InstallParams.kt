package cloud.drakon.tempest.application

import kotlinx.serialization.Serializable

/**
 * @property scopes the scopes to add the application to the server with
 * @property permissions the permissions to request for the bot role
 */
@Serializable class InstallParams(val scopes: Array<String>, val permissions: String)
