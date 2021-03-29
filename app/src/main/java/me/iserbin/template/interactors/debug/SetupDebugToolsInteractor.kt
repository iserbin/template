package me.iserbin.template.interactors.debug

import me.iserbin.common.logging.FirebaseCrashlyticsTimberTree
import me.iserbin.common.logging.NumberedTimberTree
import timber.log.Timber
import javax.inject.Inject

class SetupDebugToolsInteractor @Inject constructor(
    private val isDebugBuildConfigInteractor: IsDebugBuildConfigInteractor,
) {
    fun initLogging() {
        val debug = isDebugBuildConfigInteractor.isDebug()
        Timber.plant(
            if (debug) NumberedTimberTree() else FirebaseCrashlyticsTimberTree()
        )
    }
}
