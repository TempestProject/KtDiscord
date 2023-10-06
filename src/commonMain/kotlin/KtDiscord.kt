package cloud.drakon.ktdiscord

import io.ktor.client.HttpClient
import io.ktor.client.plugins.UserAgent
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtDiscord(
    applicationId: Snowflake,
    publicKey: String,
    botToken: String,
    ignoreUnknownKeys: Boolean = false,
) {
    private val ktorClient = HttpClient {
        install(UserAgent) {
            agent = "DiscordBot (https://github.com/TempestProject/KtDiscord, 7.0.0-SNAPSHOT)"
        }

        defaultRequest {
            url("https://discord.com/api/v10/")
            header("Authorization", "Bot $botToken")
        }

        install(ContentNegotiation) {
            json(if (ignoreUnknownKeys) Json {
                this.ignoreUnknownKeys = true
            } else Json)
        }
    }
}
