package com.cirodevs.indrverclonekotlin.domain.util

// este recurso nos va a permitir la repsonse de la api si es exitosa o no
// la clase debe ser sellafa de tipo T (generica)
sealed class Resource <out T> {
    object Loading : Resource<Nothing>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Failure<out T>(val message: String) : Resource<T>()
}