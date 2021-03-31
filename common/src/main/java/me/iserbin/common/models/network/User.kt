package me.iserbin.common.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("session")
    @Expose
    var session: Session? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("realname")
    @Expose
    var realname: String? = null

    @SerializedName("image")
    @Expose
    var image: List<Image>? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("age")
    @Expose
    var age: String? = null

    @SerializedName("gender")
    @Expose
    var gender: String? = null

    @SerializedName("subscriber")
    @Expose
    var subscriber: String? = null

    @SerializedName("playcount")
    @Expose
    var playcount: String? = null

    @SerializedName("playlists")
    @Expose
    var playlists: String? = null

    @SerializedName("bootstrap")
    @Expose
    var bootstrap: String? = null

    @SerializedName("registered")
    @Expose
    var registered: Registered? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("scrobblesource")
    @Expose
    var scrobblesource: String? = null

    @SerializedName("recenttrack")
    @Expose
    var recentTrack: RecentTrack? = null

    override fun toString(): String {
        return "User(session=$session, name=$name, realname=$realname, image=$image, url=$url, country=$country, age=$age, gender=$gender, subscriber=$subscriber, playcount=$playcount, playlists=$playlists, bootstrap=$bootstrap, registered=$registered, type=$type, scrobblesource=$scrobblesource, recentTrack=$recentTrack)"
    }
}
