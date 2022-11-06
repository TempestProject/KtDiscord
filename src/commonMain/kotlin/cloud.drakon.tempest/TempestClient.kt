package cloud.drakon.tempest

import cloud.drakon.tempest.interaction.TempestInteractions
import io.ktor.client.*

expect val KtorClient: HttpClient

class TempestClient(ApplicationId: Long, BotToken: String) {
    private val botToken = "Bot $BotToken"

    val interaction: TempestInteractions = TempestInteractions(ApplicationId = ApplicationId, BotToken = botToken)
}
