package me.iserbin.common.arch

import android.view.View
import java.lang.System.currentTimeMillis
import java.security.MessageDigest

fun View.setOnSingleClick(onClick: () -> Unit) {
    var lastClickTime = 0L
    setOnClickListener {
        if (currentTimeMillis() > lastClickTime + 500) onClick()
        lastClickTime = currentTimeMillis()
    }
}

fun String.toMD5(): String {
    val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
    return bytes.toHex()
}

fun ByteArray.toHex(): String {
    return joinToString("") { "%02x".format(it) }
}
