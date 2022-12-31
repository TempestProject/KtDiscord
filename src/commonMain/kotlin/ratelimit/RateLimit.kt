package cloud.drakon.ktdiscord.ratelimit

internal data class RateLimit(
    val limit: Byte,
    val remaining: Byte,
    val reset: Double,
    val resetAfter: Double,
)
