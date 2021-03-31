package me.iserbin.template.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.iserbin.network.RepositoryLastFm
import me.iserbin.network.SigGenerator
import me.iserbin.template.BuildConfig
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val sigGenerator: SigGenerator,
    private val repositoryLastFm: RepositoryLastFm,
) : ViewModel() {

    private val apiKey by lazy { BuildConfig.LAST_FM_API_KEY }
    private val sharedSecret by lazy { BuildConfig.LAST_FM_SHARED_SECRET }

    fun onButtonClicked(name: String, password: String) {
        Timber.d("-> args: name: $name, password: $password")
        val errorMessage = validateArgs(name, password)
        if (errorMessage.isNotBlank()) {
            doError(errorMessage)
            return
        }
        val result = sigGenerator.generateAuthSig(
            username = name,
            password = password,
            apiKey = apiKey,
            apiSecret = sharedSecret,
        )
        if (result.isFailure) {
            doError(result.exceptionOrNull()?.message)
            return
        }
        val authSignature = result.getOrNull()
        if (authSignature.isNullOrBlank()) {
            doError(result.exceptionOrNull()?.message)
            return
        }
        viewModelScope.launch {
            val session = repositoryLastFm.getMobileSession(
                password = password,
                username = name,
                apiKey = apiKey,
                apiSig = authSignature,
            )
            if (session.isFailure) {
                Timber.d("-> error: ${session.exceptionOrNull()?.message}")
                return@launch
            }
            Timber.d("-> here success: ${session.getOrNull()}")
        }
    }

    private fun validateArgs(
        name: String,
        password: String,
    ): String {
        val apiKeyOk = apiKey.isNotBlank()
        val apiSecretOk = sharedSecret.isNotBlank()
        val nameOk = name.isNotBlank()
        val passwordOk = password.isNotBlank()
        return when {
            !apiKeyOk -> "API key not ok"
            !apiSecretOk -> "API secret not ok"
            !nameOk -> "name not ok"
            !passwordOk -> "password not ok"
            else -> ""
        }
    }

    private fun doError(message: String? = null) {
        // todo create error processing logic
        Timber.e("-> error: $message")
    }
}
