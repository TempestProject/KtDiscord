package cloud.drakon.tempest

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.contentType

actual val KtorClient: HttpClient = HttpClient(Js) {
    defaultRequest {
        contentType(ContentType.Application.Json)
        url("https://discord.com/api/v10/")
    }
}
