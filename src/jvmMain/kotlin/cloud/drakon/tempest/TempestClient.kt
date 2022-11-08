package cloud.drakon.tempest

import io.ktor.client.HttpClient
import io.ktor.client.engine.java.Java
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header

actual val KtorClient: HttpClient = HttpClient(Java) {
    defaultRequest {
        header("Content-Type", "application/json")
        url("https://discord.com/api/v10")
    }
}
