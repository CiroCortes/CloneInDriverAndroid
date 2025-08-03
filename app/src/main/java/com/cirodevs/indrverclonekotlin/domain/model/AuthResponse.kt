package com.cirodevs.indrverclonekotlin.domain.model

data class AuthResponse (
    // dejamos nullables los campos YA QUE PODEMOOS TENER UNA RESPUESTA DE SYATUS CODE 401, Y UN MENSAJE DE ERROR
    val user: User? = null,
    val token: String? = null

)