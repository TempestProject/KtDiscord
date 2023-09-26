@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.reference

import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@JsExport @Serializable enum class Locale {
    @SerialName("id") INDONESIAN,
    @SerialName("da") DANISH,
    @SerialName("de") GERMAN,
    @SerialName("en-GB") ENGLISH_UK,
    @SerialName("en-US") ENGLISH_US,
    @SerialName("es-ES") SPANISH,
    @SerialName("hr") CROATIAN,
    @SerialName("it") ITALIAN,
    @SerialName("lt") LITHUANIAN,
    @SerialName("hu") HUNGARIAN,
    @SerialName("nl") DUTCH,
    @SerialName("no") NORWEGIAN,
    @SerialName("pl") POLISH,
    @SerialName("pt-BR") PORTUGUESE_BRAZILIAN,
    @SerialName("ro") ROMANIAN_ROMANIA,
    @SerialName("fi") FINNISH,
    @SerialName("sv-SE") SWEDISH,
    @SerialName("vi") VIETNAMESE,
    @SerialName("tr") TURKISH,
    @SerialName("cs") CZECH,
    @SerialName("el") GREEK,
    @SerialName("bg") BULGARIAN,
    @SerialName("ru") RUSSIAN,
    @SerialName("uk") UKRAINIAN,
    @SerialName("hi") HINDI,
    @SerialName("th") THAI,
    @SerialName("zh-CN") CHINESE_CHINA,
    @SerialName("ja") JAPANESE,
    @SerialName("zh-TW") CHINESE_TAIWAN,
    @SerialName("ko") KOREAN,
}
