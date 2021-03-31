package me.iserbin.common.arch

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executors

data class CoroutineDispatchers(
    val database: CoroutineDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher(),
    val disk: CoroutineDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher(),
    val network: CoroutineDispatcher = Dispatchers.IO,
    val main: CoroutineDispatcher = Dispatchers.Main,
    val default: CoroutineDispatcher = Dispatchers.Default
)