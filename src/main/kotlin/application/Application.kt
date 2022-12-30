package cloud.drakon.discordkt.application

import cloud.drakon.discordkt.teams.Team
import cloud.drakon.discordkt.user.User
import kotlinx.serialization.Serializable

/**
 * @property id the id of the app
 * @property name the name of the app
 * @property icon the icon hash of the app
 * @property description the description of the app
 * @property rpc_origins an array of rpc origin urls, if rpc is enabled
 * @property bot_public when false only app owner can join the app's bot to guilds
 * @property bot_require_code_grant when true the app's bot will only join upon completion of the full oauth2 code grant flow
 * @property terms_of_service_url the url of the app's terms of service
 * @property privacy_policy_url the url of the app's privacy policy
 * @property owner partial user object containing info on the owner of the application
 * @property summary **deprecated and will be removed in v11.** An empty string.
 * @property verify_key the hex encoded key for verification in interactions and the GameSDK's GetTicket
 * @property team if the application belongs to a team, this will be a list of the members of that team
 * @property guild_id if this application is a game sold on Discord, this field will be the guild to which it has been linked
 * @property primary_sku_id if this application is a game sold on Discord, this field will be the id of the "Game SKU" that is created, if exists
 * @property slug if this application is a game sold on Discord, this field will be the URL slug that links to the store page
 * @property cover_image the application's default rich presence invite cover image hash
 * @property flags the application's public flags
 * @property tags up to 5 tags describing the content and functionality of the application
 * @property install_params settings for the application's default in-app authorization link, if enabled
 * @property custom_install_url the application's default custom authorization link, if enabled
 */
@Serializable class Application(
    val id: String,
    val name: String,
    val icon: String?,
    val description: String,
    val rpc_origins: String? = null,
    val bot_public: Boolean,
    val bot_require_code_grant: Boolean,
    val terms_of_service_url: String? = null,
    val privacy_policy_url: String? = null,
    val owner: User? = null,
    @Deprecated(message = "deprecated and will be removed in v11.")
    val summary: String? = null,
    val verify_key: String,
    val team: Team?,
    val guild_id: String? = null,
    val primary_sku_id: String? = null,
    val slug: String? = null,
    val cover_image: String? = null,
    val flags: String? = null,
    val tags: Array<String>? = null,
    val install_params: InstallParams? = null,
    val custom_install_url: String? = null,
)
