package me.iserbin.common.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Links {
    @SerializedName("link")
    @Expose
    var link: Link? = null
}
