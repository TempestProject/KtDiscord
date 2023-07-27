package cloud.drakon.ktdiscord.application

import cloud.drakon.ktdiscord.teams.Team
import cloud.drakon.ktdiscord.user.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @property id the id of the app
 * @property name the name of the app
 * @property icon the icon hash of the app
 * @property description the description of the app
 * @property rpcOrigins an array of rpc origin urls, if rpc is enabled
 * @property botPublic when false only app owner can join the app's bot to guilds
 * @property botRequireCodeGrant when true the app's bot will only join upon completion of the full oauth2 code grant flow
 * @property termsOfServiceUrl the url of the app's terms of service
 * @property privacyPolicyUrl the url of the app's privacy policy
 * @property owner partial user object containing info on the owner of the application
 * @property summary **deprecated and will be removed in v11.** An empty string.
 * @property verifyKey the hex encoded key for verification in interactions and the GameSDK's GetTicket
 * @property team if the application belongs to a team, this will be a list of the members of that team
 * @property guildId if this application is a game sold on Discord, this field will be the guild to which it has been linked
 * @property primarySkuId if this application is a game sold on Discord, this field will be the id of the "Game SKU" that is created, if exists
 * @property slug if this application is a game sold on Discord, this field will be the URL slug that links to the store page
 * @property coverImage the application's default rich presence invite cover image hash
 * @property flags the application's public flags
 * @property tags up to 5 tags describing the content and functionality of the application
 * @property installParams settings for the application's default in-app authorization link, if enabled
 * @property customInstallUrl the application's default custom authorization link, if enabled
 */
@Serializable class Application(
    val id: String,
    val name: String,
    val icon: String?,
    val description: String,
    @SerialName("rpc_origins") val rpcOrigins: String? = null,
    @SerialName("bot_public") val botPublic: Boolean,
    @SerialName("bot_require_code_grant") val botRequireCodeGrant: Boolean,
    @SerialName("terms_of_service_url") val termsOfServiceUrl: String? = null,
    @SerialName("privacy_policy_url") val privacyPolicyUrl: String? = null,
    val owner: User? = null,
    @Deprecated(message = "deprecated and will be removed in v11.")
    val summary: String? = null,
    @SerialName("verify_key") val verifyKey: String,
    val team: Team?,
    @SerialName("guild_id") val guildId: String? = null,
    @SerialName("primary_sku_id") val primarySkuId: String? = null,
    val slug: String? = null,
    @SerialName("cover_image") val coverImage: String? = null,
    val flags: String? = null,
    val tags: List<String>? = null,
    @SerialName("install_params") val installParams: InstallParams? = null,
    @SerialName("custom_install_url") val customInstallUrl: String? = null,
)
