package cloud.drakon.ktdiscord

import io.ktor.client.statement.HttpResponse

expect class KtDiscordClient(applicationId: String, botToken: String, publicKey: String)

internal fun rateLimitToMilliseconds(response: HttpResponse): Long =
    (response.headers["X-RateLimit-Reset-After"] !!.toDouble() * 1000).toLong()
