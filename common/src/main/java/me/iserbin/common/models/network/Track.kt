package me.iserbin.common.models.network

import com.google.gson.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type

class Track {
    @SerializedName("corrected")
    @Expose
    var corrected: String? = null

    @SerializedName("#text")
    @Expose
    var text: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("playcount")
    @Expose
    var playcount: String? = null

    @SerializedName("loved")
    @Expose
    var loved: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("duration")
    @Expose
    var duration: String? = null

    @SerializedName("@attr")
    @Expose
    var attr: Attr? = null

    @SerializedName("streamable")
    @Expose
    var streamable: Any? = null

    @SerializedName("artist")
    @Expose
    var artist: Artist? = null

    @SerializedName("date")
    @Expose
    var date: Date? = null

    @SerializedName("image")
    @Expose
    var image: List<Image_>? = null

    @SerializedName("mbid")
    @Expose
    var mbid: String? = null

    @SerializedName("album")
    @Expose
    var album: Album? = null

    override fun toString(): String {
        return artist!!.text + " - " + name
    }

    // this is necessary as API returns different types
    class TrackDataStateDeserializer : JsonDeserializer<Track?> {
        @Throws(JsonParseException::class)
        override fun deserialize(
            json: JsonElement,
            typeOfT: Type?,
            context: JsonDeserializationContext?
        ): Track {
            val track: Track = Gson().fromJson(json, Track::class.java)
            val jsonObject: JsonObject = json.getAsJsonObject()
            if (jsonObject.has("streamable")) {
                val elem: JsonElement = jsonObject.get("streamable")
                if (elem != null && !elem.isJsonNull()) {
                    if (elem.isJsonPrimitive()) {
                        track.streamable = elem.getAsString()
                    } else {
                        track.streamable = Gson().fromJson(elem, Streamable::class.java)
                    }
                }
            }
            return track
        }
    }
}
