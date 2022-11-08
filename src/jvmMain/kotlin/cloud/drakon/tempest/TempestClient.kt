package cloud.drakon.tempest

import io.ktor.client.HttpClient
import io.ktor.client.engine.java.Java
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.contentType

actual val KtorClient: HttpClient = HttpClient(Java) {
    defaultRequest {
        contentType(ContentType.Application.Json)
        url("https://discord.com/api/v10/")
    }
}
