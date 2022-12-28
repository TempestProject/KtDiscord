package cloud.drakon.tempest

import kotlinx.serialization.Serializable

@Serializable class File(
    val id: String,
    val filename: String,
    val contentType: String,
    val bytes: ByteArray,
)
