package cloud.drakon.tempest

import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*

actual val KtorClient: HttpClient = HttpClient(Js) {
    defaultRequest {
        header("Content-Type", "application/json")
        url("https://discord.com/api/v10")
    }
}
