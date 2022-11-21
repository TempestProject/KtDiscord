package cloud.drakon.tempest

import java.security.KeyFactory
import java.security.Signature
import java.security.spec.X509EncodedKeySpec

actual class TempestClient actual constructor(
    private val applicationId: String,
    private val botToken: String,
    private val publicKey: String,
) {
    fun validateRequest(timestamp: String, body: String, signature: String): Boolean {
        val validateSignature = Signature.getInstance("Ed25519")

        validateSignature.initVerify(
            KeyFactory.getInstance("Ed25519")
                .generatePublic(X509EncodedKeySpec(publicKey.toByteArray()))
        )

        validateSignature.update((timestamp + body).toByteArray())
        return validateSignature.verify(signature.toByteArray())
    }
}
