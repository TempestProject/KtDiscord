@file:OptIn(ExperimentalJsExport::class)

package cloud.drakon.ktdiscord.channel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

/**
 * The thread metadata object contains a number of thread-specific channel fields that are not needed by other channel types.
 * @property archived Whether the thread is archived.
 * @property autoArchiveDuration The thread will stop showing in the channel list after `autoArchiveDuration` minutes of inactivity.
 * @property archiveTimestamp Timestamp when the thread's archive status was last changed, used for calculating recent activity.
 * @property locked Whether the thread is locked; when a thread is locked, only users with `MANAGE_THREADS` can unarchive it.
 * @property invitable Whether non-moderators can add other non-moderators to a thread; only available on private threads.
 * @property createTimestamp Timestamp when the thread was created; only populated for threads created after 2022-01-09.
 */
@JsExport @Serializable
data class ThreadMetadata(
    val archived: Boolean,
    @SerialName("auto_archive_duration") val autoArchiveDuration: Short,
    @SerialName("archive_timestamp") val archiveTimestamp: String,
    val locked: Boolean,
    val invitable: Boolean? = null,
    @SerialName("create_timestamp") val createTimestamp: String? = null,
)
