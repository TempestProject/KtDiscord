package cloud.drakon.discordkt.webbook

import cloud.drakon.discordkt.file.File
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable internal sealed interface Webhook {
    @Transient val files: Array<File>?
}
