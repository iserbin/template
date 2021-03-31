package me.iserbin.common.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Registered {
    @SerializedName("#text")
    @Expose
    var text: String? = null

    @SerializedName("unixtime")
    @Expose
    var unixtime: String? = null
}
