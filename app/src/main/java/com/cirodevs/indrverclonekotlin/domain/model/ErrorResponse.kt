package com.cirodevs.indrverclonekotlin.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorResponse (
    val statusCode : Int = 500,
    @Json(name = "message") private val _message : Any? = null,
    //val message : String = ""
){
    // manejamos propiedad tanto string como arrays
    val message : String
        get() = when(_message){
            is String -> _message
            is List<*> -> _message.joinToString("\n")// une los mensajes con saltos de linea
            else -> "Error desconocido"
        }
}