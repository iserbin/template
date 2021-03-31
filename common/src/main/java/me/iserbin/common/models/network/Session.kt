package me.iserbin.common.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Session {
    @SerializedName("subscriber")
    @Expose
    var subscriber: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("key")
    @Expose
    var key: String? = null
}
