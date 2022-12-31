package cloud.drakon.ktdiscord.webhook

import cloud.drakon.ktdiscord.file.File
import kotlin.js.JsExport
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@JsExport @Serializable internal sealed interface Webhook {
    @Transient val files: Array<File>?
}
