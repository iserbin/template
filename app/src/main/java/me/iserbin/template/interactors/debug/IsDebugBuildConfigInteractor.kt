package me.iserbin.template.interactors.debug

import me.iserbin.template.BuildConfig
import javax.inject.Inject

class IsDebugBuildConfigInteractor @Inject constructor() {
    fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }
}
