package com.cirodevs.indrverclonekotlin.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User (
    // here we add the optional id,image and notificationToken, because they are not required
    @SerializedName("id") val id: Long? = null,
    @SerializedName("name") val name: String,
    @SerializedName("lastname") val lastname: String,
    @SerializedName("email") val email: String? = null,
    @SerializedName("phone") val phone: String,
    @SerializedName("image") val image: String? = null,
    @SerializedName("notification_token") val notificationToken: Any? = null,
    @SerializedName("roles") val roles: List<Role>? = null,
    @SerializedName("password") val password: String? = null, // this is optional and would be null

) : Serializable {
    fun toJson(): String = Gson().toJson(User(
        id = id,
        name = name,
        lastname = lastname,
        email = email,
        phone = phone

    ))
    companion object {
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }
}
