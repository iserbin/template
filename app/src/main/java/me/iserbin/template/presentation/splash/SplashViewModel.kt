package me.iserbin.template.presentation.splash

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.iserbin.common.navigation.NavigationDispatcher
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navigationDispatcher: NavigationDispatcher,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        viewModelScope.launch {
            delay(2000)
            navigationDispatcher.emit {
                it.navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
            }
        }
    }

    fun checkRegistration() {
        Timber.d("-> ")
    }
}
