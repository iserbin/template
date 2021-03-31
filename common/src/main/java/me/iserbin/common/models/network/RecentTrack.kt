package me.iserbin.common.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RecentTrack {
    @SerializedName("artist")
    @Expose
    var artist: Artist? = null

    @SerializedName("album")
    @Expose
    var album: Album? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("mbid")
    @Expose
    var mbid: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("@attr")
    @Expose
    var attr: Attr? = null
}