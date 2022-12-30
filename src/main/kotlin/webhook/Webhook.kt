package cloud.drakon.ktdiscord.webhook

import cloud.drakon.ktdiscord.file.File
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable internal sealed interface Webhook {
    @Transient val files: Array<File>?
}
