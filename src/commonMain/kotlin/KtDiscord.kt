package cloud.drakon.ktdiscord

import io.ktor.client.statement.HttpResponse

internal const val VERSION = "6.0.0"

expect class KtDiscord(applicationId: String, botToken: String) {
    inner class Interaction

    inner class ApplicationCommands {
        inner class Guild
    }
}

internal fun rateLimitToMilliseconds(response: HttpResponse): Long =
    (response.headers["X-RateLimit-Reset-After"] !!.toDouble() * 1000).toLong()
