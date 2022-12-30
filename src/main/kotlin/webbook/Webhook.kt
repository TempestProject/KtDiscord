package cloud.drakon.tempest.webbook

import cloud.drakon.tempest.file.File
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable internal sealed interface Webhook {
    @Transient val files: Array<File>?
}
