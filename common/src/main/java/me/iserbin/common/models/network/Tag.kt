package me.iserbin.common.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Tag {
    @SerializedName("count")
    @Expose
    var count: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null
}
