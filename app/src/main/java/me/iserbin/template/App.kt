package me.iserbin.template

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import me.iserbin.template.interactors.debug.SetupDebugToolsInteractor
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var setupDebugToolsInteractor: SetupDebugToolsInteractor

    override fun onCreate() {
        super.onCreate()
        setupDebugToolsInteractor.initLogging()
    }
}