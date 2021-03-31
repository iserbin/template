package me.iserbin.common.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Link {
    @SerializedName("#text")
    @Expose
    var text: String? = null

    @SerializedName("rel")
    @Expose
    var rel: String? = null

    @SerializedName("href")
    @Expose
    var href: String? = null
}
