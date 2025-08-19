package com.cirodevs.indrverclonekotlin.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class User (
    // here we add the optional id,image and notificationToken, because they are not required
    @SerializedName("id") val id: Long? = null,
    @SerializedName("name") var name: String,
    @SerializedName("lastname") var lastname: String,
    @SerializedName("email") val email: String? = null,
    @SerializedName("phone") var phone: String,
    @SerializedName("image") var image: String? = null,
    @SerializedName("notification_token") val notificationToken: Any? = null,
    @SerializedName("roles") val roles: List<Role>? = null,
    @SerializedName("password") val password: String? = null, // this is optional and would be null

) : Serializable {
    fun toJson(): String = Gson().toJson(User(
        id = id,
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        // here we don´t pass a image whit a http in a route, we must use a URL enconder
        // so we can pass a parameter to other route
        image = if (!image.isNullOrBlank()) URLEncoder.encode(
            image,
            StandardCharsets.UTF_8.toString()
        ) else null,

    ))
    companion object {
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }
}
