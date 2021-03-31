package me.iserbin.network.api

import me.iserbin.common.arch.Rezult
import me.iserbin.common.models.network.User

interface ApiLastFm {
    suspend fun getMobileSession(
        password: String,
        username: String,
        apiKey: String,
        apiSig: String,
    ): Rezult<User>
}