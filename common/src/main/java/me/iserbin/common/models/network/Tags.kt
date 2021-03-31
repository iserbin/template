package me.iserbin.common.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Tags {
    @SerializedName("tag")
    @Expose
    var tag: List<Tag>? = null
}
