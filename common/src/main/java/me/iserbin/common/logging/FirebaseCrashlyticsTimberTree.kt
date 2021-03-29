package me.iserbin.common.logging

import android.util.Log
import timber.log.Timber

class FirebaseCrashlyticsTimberTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }
        // TODO-Implement FirebaseCrashlytics if needed
        if (priority == Log.INFO) {
//            FirebaseCrashlytics.getInstance().log(message)
            return
        }
//        FirebaseCrashlytics.getInstance().recordException(t ?: Exception(message))
    }
}
