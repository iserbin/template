package me.iserbin.common.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Streamable {
    @SerializedName("#text")
    @Expose
    var text: String? = null

    @SerializedName("fulltrack")
    @Expose
    var fulltrack: String? = null
}
