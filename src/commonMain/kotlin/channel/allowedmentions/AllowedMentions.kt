package cloud.drakon.tempest.channel.allowedmentions

import kotlinx.serialization.Serializable

/**
 * The allowed mention field allows for more granular control over mentions without various hacks to the message content. This will always validate against message content to avoid phantom pings (e.g. to ping everyone, you must still have `@everyone` in the message content), and check against user/bot permissions.
 */
@Serializable class AllowedMentions(
    val parse: Array<String>,
    val roles: Array<String>,
    val users: Array<String>,
    val replied_user: Boolean,
)
