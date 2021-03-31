package me.iserbin.common.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Image {
    @SerializedName("#text")
    @Expose
    var text: String? = null

    @SerializedName("size")
    @Expose
    var size: String? = null
}