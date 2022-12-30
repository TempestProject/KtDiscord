package cloud.drakon.tempest.webbook

import cloud.drakon.tempest.File

interface Webhook {
    val files: Array<File>?
}
