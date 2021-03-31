package me.iserbin.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.iserbin.common.arch.CoroutineDispatchers
import me.iserbin.common.arch.Network
import me.iserbin.network.BuildConfig
import me.iserbin.network.api.ApiLastFm
import me.iserbin.network.api.ApiLastFmImpl
import me.iserbin.network.api.ContractLastFm
import me.iserbin.network.api.ServiceLastFm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl() = ContractLastFm.LAST_FM_API_URL_SECURE

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        baseUrl: String
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ServiceLastFm::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(lastFmApiImpl: ApiLastFmImpl): ApiLastFm = lastFmApiImpl

    @Provides
    @Singleton
    @Network
    fun providesNetworkCoroutineContext(): CoroutineContext = CoroutineDispatchers().network
}