@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord

import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport class KtDiscord {
    private val ktorClient = HttpClient {
        defaultRequest {
            url("https://discord.com/api/v10/")
        }
    }
}
