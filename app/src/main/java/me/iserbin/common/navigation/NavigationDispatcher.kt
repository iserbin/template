package me.iserbin.common.navigation

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@ActivityRetainedScoped
class NavigationDispatcher @Inject constructor() {

    private val navigationEmitter: MutableSharedFlow<NavigationCommand> = MutableSharedFlow()
    val navigationCommands: SharedFlow<NavigationCommand> = navigationEmitter

    suspend fun emit(navigationCommand: NavigationCommand) {
        navigationEmitter.emit(navigationCommand)
    }
}
