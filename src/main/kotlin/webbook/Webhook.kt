package cloud.drakon.tempest.webbook

import cloud.drakon.tempest.File
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable sealed interface Webhook {
    @Transient val files: Array<File>?
}
