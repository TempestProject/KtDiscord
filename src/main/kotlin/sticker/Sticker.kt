package cloud.drakon.discordkt.sticker

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a sticker that can be sent in messages.
 * @property id id of the sticker
 * @property packId for standard stickers, id of the pack the sticker is from
 * @property name name of the sticker
 * @property description description of the sticker
 * @property tags autocomplete/suggestion tags for the sticker (max 200 characters). A comma separated list of keywords is the format used in this field by standard stickers, but this is just a convention. Incidentally the client will always use a name generated from an emoji as the value of this field when creating or modifying a guild sticker.
 * @property asset Deprecated previously the sticker asset hash, now an empty string
 * @property type type of sticker
 * @property formatType type of sticker format
 * @property available whether this guild sticker can be used, may be false due to loss of Server Boosts
 * @property guildId id of the guild that owns this sticker
 * @property user the user that uploaded the guild sticker
 * @property sortValue the standard sticker's sort order within its pack
 */
@Serializable class Sticker(
    val id: String,
    @SerialName("pack_id") val packId: String? = null,
    val name: String,
    val description: String?,
    val tags: String,
    val asset: String? = null,
    val type: Byte,
    @SerialName("format_type") val formatType: Byte,
    val available: Boolean? = null,
    @SerialName("guild_id") val guildId: String? = null,
    val user: String? = null,
    @SerialName("sort_value") val sortValue: UInt? = null,
)
