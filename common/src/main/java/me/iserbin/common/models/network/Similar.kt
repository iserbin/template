package me.iserbin.common.models.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Similar {
    @SerializedName("artist")
    @Expose
    var artist: List<Artist>? = null
}
