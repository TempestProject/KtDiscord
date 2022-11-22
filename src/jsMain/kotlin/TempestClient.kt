package cloud.drakon.tempest

actual class TempestClient actual constructor(
    private val applicationId: String,
    private val botToken: String,
    private val publicKey: String,
) {
    fun validateRequest(timestamp: String, body: String, signature: String) {
        
    }
}
