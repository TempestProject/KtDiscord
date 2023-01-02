package cloud.drakon.ktdiscord

import io.ktor.client.statement.HttpResponse

internal const val VERSION = "3.0.0-SNAPSHOT"

expect class KtDiscordClient(applicationId: String, botToken: String, publicKey: String)

internal fun rateLimitToMilliseconds(response: HttpResponse): Long =
    (response.headers["X-RateLimit-Reset-After"] !!.toDouble() * 1000).toLong()
