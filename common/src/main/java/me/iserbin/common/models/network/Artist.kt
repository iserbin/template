package me.iserbin.common.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Artist : Favoritable {
    @SerializedName("corrected")
    @Expose
    var corrected: String? = null

    @SerializedName("#text")
    @Expose
    var text: String? = null

    @SerializedName("name")
    @Expose
    override var name: String? = null

    @SerializedName("mbid")
    @Expose
    var mbid: String? = null

    @SerializedName("playcount")
    @Expose
    var playcount: String? = null

    @SerializedName("listeners")
    @Expose
    var listeners: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("image")
    @Expose
    var image: List<Image>? = null

    @SerializedName("streamable")
    @Expose
    var streamable: String? = null

    @SerializedName("ontour")
    @Expose
    var ontour: String? = null

    @SerializedName("stats")
    @Expose
    var stats: Stats? = null

    @SerializedName("similar")
    @Expose
    var similar: Similar? = null

    @SerializedName("tags")
    @Expose
    var tags: Tags? = null

    @SerializedName("bio")
    @Expose
    var bio: Bio? = null

    override fun toString(): String {
        return name.toString()
    }
}
