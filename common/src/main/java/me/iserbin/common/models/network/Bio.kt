package me.iserbin.common.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Bio {
    @SerializedName("links")
    @Expose
    var links: Links? = null

    @SerializedName("published")
    @Expose
    var published: String? = null

    @SerializedName("summary")
    @Expose
    var summary: String? = null

    @SerializedName("content")
    @Expose
    var content: String? = null
}
