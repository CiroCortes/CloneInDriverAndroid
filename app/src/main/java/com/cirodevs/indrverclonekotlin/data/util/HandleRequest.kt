package com.cirodevs.indrverclonekotlin.data.util

import android.util.Log
import com.cirodevs.indrverclonekotlin.domain.model.ErrorResponse
import com.cirodevs.indrverclonekotlin.domain.util.ErrorHelper
import com.cirodevs.indrverclonekotlin.domain.util.Resource
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

// when we use the type "T", it means that we can use any type (generic), don't know the type
// information we could can receive

object HandleRequest {

    fun <T> send(result : Response<T>, tag:String ="HandleRequest") : Resource<T> {
        return try {

            if(result.isSuccessful){
                Log.d(tag,  "Data: ${result.body()}")
                Resource.Success(result.body()!!) // doble admiracion por si viene null
            }else{
                Log.d(tag,  "Error en la peticion")
                val errorResponse : ErrorResponse? = ErrorHelper.handleError(result.errorBody())
                // we passed the errorResponse to the Resource.Failure, in other wise we show the text "Error en la peticion"
                Resource.Failure( errorResponse?.message ?: "An unknown error occurred" )
            }
        }catch (e: HttpException) {
            Log.d("${tag} : HttpException",  "Message: ${e}")
            Log.d("${tag} : HttpException",  "Message Cause: ${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message ?: "error DESCONOCIDO")

        }catch (e: IOException) {
            Log.d("${tag} : IOException",  "Message: ${e}")
            Log.d("${tag} : IOException",  "Message Cause: ${e.cause}")
            e.printStackTrace()
            Resource.Failure("VERIFICA TU CONEXION A INTERNET")

        }

        catch (e: Exception) {
            Log.d(tag,  "Message: ${e}")
            Log.d(tag,  "Message Cause: ${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message ?: "error DESCONOCIDO")

        }

    }
}