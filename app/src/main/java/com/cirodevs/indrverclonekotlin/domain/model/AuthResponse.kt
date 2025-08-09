package com.cirodevs.indrverclonekotlin.domain.model

import com.google.gson.Gson

data class AuthResponse (
    // dejamos nullables los campos YA QUE PODEMOOS TENER UNA RESPUESTA DE SYATUS CODE 401, Y UN MENSAJE DE ERROR
    val user: User? = null,
    val token: String? = null

) {
    fun toJson(): String = Gson().toJson(this)

    // this is a static method like java static, for convert json to object
    companion object {
        fun fromJson(data: String): AuthResponse = Gson().fromJson(data, AuthResponse::class.java)
    }
}