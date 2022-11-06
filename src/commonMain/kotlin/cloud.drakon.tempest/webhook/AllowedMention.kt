package cloud.drakon.tempest.webhook

class AllowedMention(
    val parse: Array<AllowedMentionTypes>,
    val roles: Array<Long>,
    val users: Array<Long>,
    val replied_user: Boolean
)

enum class AllowedMentionTypes(val AllowedMentionTypes: String) {
    ROLE_MENTIONS("role"),
    USER_MENTIONS("users"),
    EVERYONE_MENTIONS("everyone")
}
