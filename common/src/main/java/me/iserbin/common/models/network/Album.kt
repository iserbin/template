package me.iserbin.common.models.network

import com.google.gson.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.google.gson.internal.LinkedTreeMap
import java.lang.reflect.Type

class Album : Favoritable {
    @SerializedName("#text")
    @Expose
    var text: String? = null

    @SerializedName("corrected")
    @Expose
    var corrected: String? = null

    @SerializedName("name")
    @Expose
    override var name: String? = null

    //this is neccecary as artist returns both string and artist object
    @SerializedName("artist")
    @Expose
    var artist: Any? = null
        get() {
            val weirdArtist = field as? LinkedTreeMap<String, String> ?: return field
            return Artist().apply {
                name = weirdArtist["name"]
                mbid = weirdArtist["mbid"]
                url = weirdArtist["url"]
            }
        }

    @SerializedName("mbid")
    @Expose
    var mbid: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("image")
    @Expose
    var image: List<Image>? = null

    @SerializedName("listeners")
    @Expose
    var listeners: String? = null

    //TODO: possible problem, as one API call for specific album returns a String playcount, the artists top album call returns a String
    @SerializedName("playcount")
    @Expose
    var playcount: Any? = null

    @SerializedName("tracks")
    @Expose
    var tracks: Tracks? = null

    @SerializedName("tags")
    @Expose
    var tags: Tags? = null

    @SerializedName("wiki")
    @Expose
    var wiki: Wiki? = null

    //this is necessary as API returns different types
    class DataStateDeserializer : JsonDeserializer<Album?> {
        @Throws(JsonParseException::class)
        override fun deserialize(
            json: JsonElement,
            typeOfT: Type?,
            context: JsonDeserializationContext?
        ): Album {
            val album: Album = Gson().fromJson(json, Album::class.java)
            val jsonObject: JsonObject = json.getAsJsonObject()
            if (jsonObject.has("artist")) {
                val elem: JsonElement = jsonObject.get("artist")
                if (elem != null && !elem.isJsonNull()) {
                    if (elem.isJsonPrimitive()) {
                        album.artist = elem.getAsString()
                    } else {
                        album.artist = Gson().fromJson(
                            elem,
                            Artist::class.java
                        )
                    }
                }
            }
            if (jsonObject.has("playcount")) {
                val elem: JsonElement = jsonObject.get("playcount")
                if (elem != null && !elem.isJsonNull()) {
                    if (elem.isJsonPrimitive()) {
                        album.playcount = elem.getAsInt()
                    } else {
                        album.playcount = elem.getAsString()
                    }
                }
            }
            return album
        }
    }
}
