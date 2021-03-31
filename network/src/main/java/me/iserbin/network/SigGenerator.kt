package me.iserbin.network

import me.iserbin.common.arch.Rezult
import me.iserbin.common.arch.toMD5
import java.util.*
import javax.inject.Inject

class SigGenerator @Inject constructor() {

    fun generateSig(
        apiKey: String,
        apiSecret: String,
        sessionKey: String,
        vararg params: String?,
    ): Rezult<String> {
        val sorted: TreeMap<String, String> = TreeMap()
        var s = ""
        sorted["api_key"] = apiKey
        sorted["sk"] = sessionKey
        var i = 0
        while (i < params.size - 1) {
            val key = params[i]
            val value = params[i + 1]
            if (key.isNullOrBlank() || value.isNullOrBlank()) break
            sorted[key] = value
            i += 2
        }
        for ((key, value) in sorted) {
            s += key + value
        }
        s += apiSecret
        return try {
            Rezult.success(s.toMD5())
        } catch (e: Exception) {
            Rezult.failure(e)
        }
    }

    fun generateAuthSig(
        username: String,
        password: String,
        apiKey: String,
        apiSecret: String,
    ): Rezult<String> {
        val s =
            "api_key${apiKey}methodauth.getMobileSessionpassword${password}username${username}${apiSecret}"
        return try {
            Rezult.success(s.toMD5())
        } catch (e: Exception) {
            Rezult.failure(e)
        }
    }

    private fun byteArrayToHex(bytes: ByteArray): String {
        val builder = StringBuilder(bytes.size * 2)
        for (b in bytes) builder.append(String.format("%02x", b))
        return builder.toString()
    }
}
