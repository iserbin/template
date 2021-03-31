package me.iserbin.network

import me.iserbin.network.api.ApiLastFm
import javax.inject.Inject

class RepositoryLastFm @Inject constructor(
    private val apiLastFm : ApiLastFm
){
    suspend fun getMobileSession(
        password: String,
        username: String,
        apiKey: String,
        apiSig: String,
    ) = apiLastFm.getMobileSession(
        password = password,
        username = username,
        apiKey = apiKey,
        apiSig = apiSig,
    )
}