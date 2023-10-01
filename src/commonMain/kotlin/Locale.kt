@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@JsExport @Serializable
enum class Locale {
    /** Bahasa Indonesia */
    @SerialName("id") INDONESIAN,

    /** Dansk */
    @SerialName("da") DANISH,

    /** Deutsch */
    @SerialName("de") GERMAN,

    /** English, UK */
    @SerialName("en-GB") ENGLISH_UK,

    /** English, US */
    @SerialName("en-US") ENGLISH_US,

    /** Español */
    @SerialName("es-ES") SPANISH,

    /** Français */
    @SerialName("fr") FRENCH,

    /** Hrvatski */
    @SerialName("hr") CROATIAN,

    /** Italiano */
    @SerialName("it") ITALIAN,

    /** Lietuviškai */
    @SerialName("lt") LITHUANIAN,

    /** Magyar */
    @SerialName("hu") HUNGARIAN,

    /** Nederlands */
    @SerialName("nl") DUTCH,

    /** Norsk */
    @SerialName("no") NORWEGIAN,

    /** Polski */
    @SerialName("pl") POLISH,

    /** Português do Brasil */
    @SerialName("pr-BR") PORTUGUESE_BRAZILIAN,

    /** Română */
    @SerialName("ro") ROMANIAN_ROMANIA,

    /** Suomi */
    @SerialName("fi") FINNISH,

    /** Svenska */
    @SerialName("sv-SE") SWEDISH,

    /** Tiếng Việt */
    @SerialName("vi") VIETNAMESE,

    /** Türkçe */
    @SerialName("tr") TURKISH,

    /** Čeština */
    @SerialName("cz") CZECH,

    /** Ελληνικά */
    @SerialName("el") GREEK,

    /** български */
    @SerialName("bg") BULGARIAN,

    /** Pусский */
    @SerialName("ru") RUSSIAN,

    /** Українська */
    @SerialName("uk") UKRAINIAN,

    /** हिन्दी */
    @SerialName("hi") HINDI,

    /** ไทย */
    @SerialName("th") THAI,

    /** 中文 */
    @SerialName("zh-CN") CHINESE_CHINA,

    /** 日本語 */
    @SerialName("ja") JAPANESE,

    /** 繁體中文 */
    @SerialName("zh-TW") CHINESE_TAIWAN,

    /** 한국어 */
    @SerialName("ko") KOREAN,
}
