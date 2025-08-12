package com.cirodevs.indrverclonekotlin.data.remote.repository

import android.util.Log
import com.cirodevs.indrverclonekotlin.data.remote.dataSource.remote.services.UserService
import com.cirodevs.indrverclonekotlin.domain.model.ErrorResponse
import com.cirodevs.indrverclonekotlin.domain.model.User
import com.cirodevs.indrverclonekotlin.domain.repository.UserRepository
import com.cirodevs.indrverclonekotlin.domain.util.ErrorHelper
import com.cirodevs.indrverclonekotlin.domain.util.Resource
import java.io.File

class UserRepositoryImpl (private val userService: UserService) : UserRepository {
    override suspend fun update(id: String, user: User, file: File?): Resource<User> {

        return try {
            val  result = userService.update(id,user)
            if(result.isSuccessful){
                Log.d("UserRepositoryImpl",  "Data: ${result.body()}")
                Resource.Success(result.body()!!) // doble admiracion por si viene null
            }else{
                Log.d("UserRepositoryImpl",  "Error en la peticion")
                val errorResponse : ErrorResponse? = ErrorHelper.handleError(result.errorBody())
                // we passed the errorResponse to the Resource.Failure, in other wise we show the text "Error en la peticion"
                Resource.Failure( errorResponse?.message ?: "An unknown error occurred" )
            }
        }catch (e: Exception) {
            Log.d("UserRepositoryImpl",  "Message: ${e}")
            Log.d("UserRepositoryImpl",  "Message Cause: ${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message ?: "error DESCONOCIDO")

        }
    }

}