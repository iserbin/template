package me.iserbin.common.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Date {
    @SerializedName("uts")
    @Expose
    var uts: String? = null

    @SerializedName("#text")
    @Expose
    var text: String? = null
}

