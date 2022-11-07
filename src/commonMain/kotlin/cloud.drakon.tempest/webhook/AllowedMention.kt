package cloud.drakon.tempest.webhook

/**
 * The allowed mention field allows for more granular control over mentions without various hacks to the message content. This will always validate against message content to avoid phantom pings (e.g. to ping everyone, you must still have @everyone in the message content), and check against user/bot permissions.
 * @property parse An array of allowed mention types to parse from the content.
 * @property roles Array of role_ids to mention (Max size of 100).
 * @property users Array of user_ids to mention (Max size of 100).
 * @property replied_user For replies, whether to mention the author of the message being replied to (default false).
 */
class AllowedMention(
    val parse: Array<AllowedMentionTypes>,
    val roles: Array<Long>,
    val users: Array<Long>,
    val replied_user: Boolean
)

enum class AllowedMentionTypes(val AllowedMentionTypes: String) {
    /** Controls role mentions. */
    ROLE_MENTIONS("role"),
    /** Controls user mentions */
    USER_MENTIONS("users"),
    /** Controls @everyone and @here mentions */
    EVERYONE_MENTIONS("everyone")
}
