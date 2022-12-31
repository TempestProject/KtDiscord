package cloud.drakon.ktdiscord.file

import kotlin.js.JsExport

@JsExport class File(
    val id: String,
    val filename: String,
    val contentType: String,
    val bytes: ByteArray,
)
