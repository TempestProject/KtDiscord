@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class MessageType {
    @SerialName("0") DEFAULT,
    @SerialName("1") RECIPIENT_ADD,
    @SerialName("2") RECIPIENT_REMOVE,
    @SerialName("3") CALL,
    @SerialName("4") CHANNEL_NAME_CHANGE,
    @SerialName("5") CHANNEL_ICON_CHANGE,
    @SerialName("6") CHANNEL_PINNED_MESSAGE,
    @SerialName("7") USER_JOIN,
    @SerialName("8") GUILD_BOOST,
    @SerialName("9") GUILD_BOOST_TIER_1,
    @SerialName("10") GUILD_BOOST_TIER_2,
    @SerialName("11") GUILD_BOOST_TIER_3,
    @SerialName("12") CHANNEL_FOLLOW_ADD,
    @SerialName("14") GUILD_DISCOVERY_DISQUALIFIED,
    @SerialName("15") GUILD_DISCOVERY_REQUALIFIED,
    @SerialName("16") GUILD_DISCOVERY_GRACE_PERIOD_INITIAL_WARNING,
    @SerialName("17") GUILD_DISCOVERY_GRACE_PERIOD_FINAL_WARNING,
    @SerialName("18") THREAD_CREATED,
    @SerialName("19") REPLY,
    @SerialName("20") CHAT_INPUT_COMMAND,
    @SerialName("21") THREAD_STARTER_MESSAGE,
    @SerialName("22") GUILD_INVITE_REMINDER,
    @SerialName("23") CONTEXT_MENU_COMMAND,
    @SerialName("24") AUTO_MODERATION_ACTION,
    @SerialName("25") ROLE_SUBSCRIPTION_PURCHASE,
    @SerialName("26") INTERACTION_PREMIUM_UPSELL,
    @SerialName("27") STAGE_START,
    @SerialName("28") STAGE_END,
    @SerialName("29") STAGE_SPEAKER,
    @SerialName("31") STAGE_TOPIC,
    @SerialName("32") GUILD_APPLICATION_PREMIUM_SUBSCRIPTION,
}
