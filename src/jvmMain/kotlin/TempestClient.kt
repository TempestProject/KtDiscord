package cloud.drakon.tempest

import com.goterl.lazysodium.LazySodiumJava
import com.goterl.lazysodium.SodiumJava
import com.goterl.lazysodium.utils.Key
import com.goterl.lazysodium.utils.LibraryLoader

actual class TempestClient actual constructor(
    private val applicationId: String,
    private val botToken: String,
    private val publicKey: String,
) {
    private val lazySodium = LazySodiumJava(SodiumJava(LibraryLoader.Mode.BUNDLED_ONLY))

    fun validateRequest(timestamp: String, body: String, signature: String): Boolean {
        return lazySodium.cryptoSignVerifyDetached(
            Key.fromHexString(signature).asHexString,
            timestamp + body,
            Key.fromHexString(publicKey)
        )
    }
}
