package cloud.drakon.ktdiscord

import io.ktor.client.statement.HttpResponse

internal const val VERSION = "4.0.0"

expect class KtDiscordClient(applicationId: String, botToken: String)

internal fun rateLimitToMilliseconds(response: HttpResponse): Long =
    (response.headers["X-RateLimit-Reset-After"] !!.toDouble() * 1000).toLong()
