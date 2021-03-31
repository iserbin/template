package me.iserbin.network.api

import kotlinx.coroutines.withContext
import me.iserbin.common.arch.Network
import me.iserbin.common.arch.Rezult
import me.iserbin.common.models.network.User
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ApiLastFmImpl @Inject constructor(
    private val serviceLastFm: ServiceLastFm,
    @Network private val networkContext: CoroutineContext,
) : ApiLastFm {

    override suspend fun getMobileSession(
        password: String,
        username: String,
        apiKey: String,
        apiSig: String,
    ): Rezult<User> {
        Timber.d("-> args: password: $password, username: $username, apiKey: $apiKey, apiSig: $apiSig")
        return withContext(networkContext) {
            try {
                val sessionToken = serviceLastFm.getMobileSession(
                    password = password,
                    username = username,
                    apiKey = apiKey,
                    apiSig = apiSig,
                )
                Rezult.success(sessionToken)
            } catch (e: Exception) {
                Rezult.failure(e)
            }
        }
    }
}