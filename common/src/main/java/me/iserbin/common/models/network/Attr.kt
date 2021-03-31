package me.iserbin.common.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Attr {
    @SerializedName("accepted")
    @Expose
    var accepted: Int? = null

    @SerializedName("ignored")
    @Expose
    var ignored: Int? = null

    @SerializedName("artist")
    @Expose
    var artist: String? = null

    @SerializedName("for")
    @Expose
    var `for`: String? = null

    @SerializedName("page")
    @Expose
    var page: String? = null

    @SerializedName("perPage")
    @Expose
    var perPage: String? = null

    @SerializedName("totalPages")
    @Expose
    var totalPages: String? = null

    @SerializedName("total")
    @Expose
    var total: String? = null

    @SerializedName("rank")
    @Expose
    var rank: String? = null

    @SerializedName("nowplaying")
    @Expose
    var nowplaying: String? = null

    fun get_for(): String? {
        return `for`
    }

    fun set_for(_for: String?) {
        `for` = _for
    }
}
