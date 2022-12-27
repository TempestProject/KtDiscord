package cloud.drakon.tempest

import kotlinx.serialization.Serializable

@Serializable class File(
    val id: Byte,
    val filename: String,
    val contentType: String,
    val bytes: ByteArray,
)
