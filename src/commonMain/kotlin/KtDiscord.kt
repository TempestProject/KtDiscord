package cloud.drakon.ktdiscord

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtDiscord(
    applicationId: Snowflake,
    publicKey: String,
    botToken: String,
) {
    private val ktorClient = HttpClient {
        defaultRequest {
            url("https://discord.com/api/v10/")
            header("Authorization", "Bot $botToken")
        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
}
