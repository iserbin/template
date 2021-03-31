package me.iserbin.network.api

import me.iserbin.common.models.network.User
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ServiceLastFm {

    @FormUrlEncoded
    @POST("auth.getMobileSession")
    suspend fun getMobileSession(
        @Field("password") password: String?,
        @Field("username") username: String?,
        @Field("api_key") apiKey: String?,
        @Field("api_sig") apiSig: String?,
    ): User
    /*
    4 : You must use POST in order to use this method.
    2 : Invalid service - This service does not exist
    3 : Invalid Method - No method with that name in this package
    4 : Authentication Failed - You do not have permissions to access the service
    5 : Invalid format - This service doesn't exist in that format
    6 : Invalid parameters - Your request is missing a required parameter
    7 : Invalid resource specified
    8 : Operation failed - Something else went wrong
    9 : Invalid session key - Please re-authenticate
    10 : Invalid API key - You must be granted a valid key by last.fm
    11 : Service Offline - This service is temporarily offline. Try again later.
    13 : Invalid method signature supplied
    16 : There was a temporary error processing your request. Please try again
    26 : Suspended API key - Access for your account has been suspended, please contact Last.fm
    29 : Rate limit exceeded - Your IP has made too many requests in a short period
    * */

    //    @GET(METHOD_CALL + "artist.getinfo")
//    fun getSpecificArtistInfo(@Query("artist") artistName: String?):
//            Observable<SpecificArtist?>?
//
//    @GET(METHOD_CALL + "artist.search")
//    fun searchForArtist(
//        @Query("artist") artistName: String?,
//        @Query("limit") limit: Int?
//    ): Observable<ArtistSearchResults?>?
//
//    @GET(METHOD_CALL + "artist.gettopalbums")
//    fun searchForArtistTopAlbums(
//        @Query("artist") artistName: String?,
//        @Query("limit") limit: Int?
//    ): Observable<TopArtistAlbums?>?
//
//    @GET(METHOD_CALL + "album.getinfo")
//    fun searchForSpecificAlbum(
//        @Query("artist") artistName: String?,
//        @Query("album") albumName: String?
//    ): Observable<SpecificAlbum?>?
//
//    @GET(METHOD_CALL + "album.search")
//    fun searchForAlbum(
//        @Query("album") albumName: String?,
//        @Query("limit") limit: Int?
//    ): Observable<GeneralAlbumSearch?>?
//
//    @GET(METHOD_CALL + "artist.gettoptags")
//    fun getArtistTopTags(@Query("artist") artistName: String?): Observable<ArtistTopTags?>?
//
//    @GET(METHOD_CALL + "chart.gettopartists")
//    fun chartTopArtists(@Query("limit") limit: Int?): Observable<TopArtistsResult?>?
//
//    @GET(METHOD_CALL + "user.getlovedtracks")
//    fun getUserLovedTracks(
//        @Query("user") username: String?,
//        @Query("limit") limit: Int
//    ): Observable<UserLovedTracks?>?
//
//    @GET(METHOD_CALL + "artist.gettoptracks")
//    fun getArtistTopTracks(
//        @Query("artist") artist: String?,
//        @Query("limit") limit: Int
//    ): Observable<ArtistTopTracks?>?
//
//    @GET(METHOD_CALL + "user.getrecenttracks")
//    fun getUserRecentTracks(
//        @Query("user") username: String?,
//        @Query("limit") limit: Int,
//        @Query("extended") extended: Int
//    ): Observable<RecentTracksWrapper?>?
//
//    @GET(METHOD_CALL + "user.getartisttracks")
//    fun getUserArtistTracks(
//        @Query("user") user: String?,
//        @Query("limit") limit: Int,
//        @Query("artist") artist: String?
//    ): Observable<UserArtistTracks?>?
//
//    @GET(METHOD_CALL + "user.gettoptracks")
//    fun getUserTopTracks(
//        @Query("user") user: String?,
//        @Query("limit") limit: Int,
//        @Query("period") period: String?
//    ): Observable<UserTopTracks?>?
//
//    @GET(METHOD_CALL + "user.gettopartists")
//    fun getUserTopArtists(
//        @Query("user") user: String?,
//        @Query("limit") limit: Int,
//        @Query("period") period: String?
//    ): Observable<UserTopArtists?>?
//
//    @GET(METHOD_CALL + "user.getinfo")
//    fun getUserInfo(
//      @Query("user") user: String?
//    ): Observable<org.gradle.internal.impldep.com.jcraft.jsch.UserInfo?>?
//
//    @GET(METHOD_CALL + "user.getfriends")
//    fun getUserFriends(
//        @Query("user") user: String?,
//        @Query("recenttracks") recentTracks: Int,
//        @Query("limit") limit: Int
//    ): Observable<UserFriends?>?
//

//
//    @FormUrlEncoded
//    @POST(Config.LAST_FM_API_URL)
//    fun scrobbleTrack(
//        @Field("method") scrobbleMethod: String?,
//        @Field("artist") artist: String?,
//        @Field("track") track: String?,
//        @Field("api_key") apiKey: String?,
//        @Field("api_sig") apiSig: String?,
//        @Field("timestamp") timestamp: Long,
//        @Field("sk") sessionKey: String?,
//        @Field("format") format: String?
//    ): Observable<Response?>?
//
//    @FormUrlEncoded
//    @POST(Config.LAST_FM_API_URL)
//    fun scrobbleTrack(
//        @Field("method") scrobbleMethod: String?,
//        @Field("artist") artist: String?,
//        @Field("track") track: String?,
//        @Field("api_key") apiKey: String?,
//        @Field("api_sig") apiSig: String?,
//        @Field("timestamp") timestamp: String?,
//        @Field("sk") sessionKey: String?,
//        @Field("format") format: String?
//    ): Observable<Response?>?
//
//    @FormUrlEncoded
//    @POST(Config.LAST_FM_API_URL)
//    fun updateNowPlaying(
//        @Field("method") updateNowPlayingMethod: String?,
//        @Field("artist") artist: String?,
//        @Field("track") track: String?,
//        @Field("api_key") apiKey: String?,
//        @Field("api_sig") apiSig: String?,
//        @Field("sk") sessionKey: String?,
//        @Field("format") format: String?
//    ): Observable<Response?>?
//
//    @FormUrlEncoded
//    @POST(Config.LAST_FM_API_URL)
//    fun loveTrack(
//        @Field("method") trackLoveMethod: String?,
//        @Field("artist") artist: String?,
//        @Field("track") track: String?,
//        @Field("api_key") apiKey: String?,
//        @Field("api_sig") apiSig: String?,
//        @Field("sk") sessionKey: String?,
//        @Field("format") format: String?
//    ): Observable<Response?>?
//
//    @FormUrlEncoded
//    @POST(Config.LAST_FM_API_URL)
//    fun unloveTrack(
//        @Field("method") trackUnloveMethod: String?,
//        @Field("artist") artist: String?,
//        @Field("track") track: String?,
//        @Field("api_key") apiKey: String?,
//        @Field("api_sig") apiSig: String?,
//        @Field("sk") sessionKey: String?,
//        @Field("format") format: String?
//    ): Observable<Response?>?

    companion object {
        const val METHOD_CALL = "?method="
    }
}

/*
@Module
class CoreNetworkModule {

    @Provides
    @Singleton
    @Named(PinngleConstants.FILES_RETROFIT)
    fun providesFileServerRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        val fileServerAddress = getFileServerAddress()
        Timber.d("-> chosen file server: $fileServerAddress")
        return Retrofit.Builder().baseUrl(fileServerAddress)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @Named(PinngleConstants.BASE_RETROFIT)
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        val baseUrl = getBaseUrl()
        Timber.d("-> chosen base: $baseUrl")
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        errorsInterceptor: ErrorsInterceptor,
        dataClientApi: DataClientApi,
        userAgentInterceptor: UserAgentInterceptor
    ): OkHttpClient {
        val client = OkHttpClient.Builder()
            // todo cache
            //  .cache(cache)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
        client.apply {
            networkInterceptors().add(StethoInterceptor())
            interceptors().apply {
                add(httpLoggingInterceptor)
                add(errorsInterceptor)
                add(userAgentInterceptor)
            }
        }

        client.patchForApiEqualOrBelow20()
        initCookies(client, dataClientApi)
        return client.build()
    }

    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = getLoggingLevel()
    }

    private fun getLoggingLevel(): HttpLoggingInterceptor.Level {
        return if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    private fun initCookies(client: OkHttpClient.Builder, dataClientApi: DataClientApi) {
        client.cookieJar(object : CookieJar {

            override fun loadForRequest(url: HttpUrl): List<okhttp3.Cookie> {
                val cookies = dataClientApi.prefGetCookies()
                return if (cookies.isNotEmpty()) {
                    cookies
                } else {
                    Timber.w("-> no cookies in prefs")
                    ArrayList()
                }
            }

            override fun saveFromResponse(url: HttpUrl, cookies: List<okhttp3.Cookie>) {
                Timber.d("-> args: url: $url, cookies: $cookies")
                // DO NOT USE COOKIES FROM HERE, BACKEND COULD SEND YOU INVALID ;)))
                //    val urlString = url.toString()
//                if (urlString.contains(PINNGLE_SERVICES_ROOT_PATH)) {
//                    Timber.d("-> COOKIE [$cookies] SAVED")
//                    if (dataClientApi.prefGetCookies().isNullOrEmpty()) {
//                        dataClientApi.prefSetCookies(cookies)
//                    }
//                }
            }
        })
    }

    @Provides
    @Singleton
    fun providesGson(): Gson = GsonBuilder()
        .registerTypeAdapter(Long::class.java, LongTypeAdapter())
        .registerTypeAdapter(Double::class.java, DoubleTypeAdapter())
        .registerTypeAdapter(Number::class.java, NumberTypeAdapter())
        .registerTypeAdapter(Integer::class.java, IntegerTypeAdapter())
        .registerTypeAdapter(Float::class.java, FloatTypeAdapter())
        .create()

    @Provides
    @Singleton
    fun providesErrorsInterceptor(): ErrorsInterceptor = ErrorsInterceptor()

    @Provides
    @Singleton
    fun providesGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Provides
    internal fun provideServerToDBMapper(): ServerToDBMapper = ServerToDBMapperImpl()

    // TODO: 15.01.21 refactoring after inject context in dagger
    @Provides
    fun providesUserAgentCreator(
        versionInfoInteractor: GetPinngleVersionInfoInteractor,
        deviceInfoProvider: GetDeviceInfoProvider
    ): UserAgentCreator = UserAgentCreator(
        context = AppContextHolder.appContext,
        versionInfoInteractor = versionInfoInteractor,
        getDeviceInfoProvider = deviceInfoProvider,
        buildUtil = BuildUtil()
    )

    // TODO: 15.01.21 refactoring after inject context in dagger
    @Provides
    fun providesVersionInfoInteractor(): GetPinngleVersionInfoInteractor =
        GetPinngleVersionInfoInteractor(
            context = AppContextHolder.appContext,
            packageManager = AppContextHolder.appContext.packageManager,
            versionUtils = VersionUtils(BuildUtil())
        )

    // TODO: 15.01.21 refactoring after inject context in dagger
//    @Provides
//    @Singleton
//    fun providesPackageManager(@App context: Context): PackageManager = context.packageManager

    @Provides
    @Singleton
    @Network
    fun providesNetworkCoroutineContext(): CoroutineContext = CoroutineDispatchers().network
}

*
* */
