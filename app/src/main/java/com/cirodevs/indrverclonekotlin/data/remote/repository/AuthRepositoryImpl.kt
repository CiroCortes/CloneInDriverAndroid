package com.cirodevs.indrverclonekotlin.data.remote.repository

import android.util.Log
import com.cirodevs.indrverclonekotlin.data.local.datastore.LocalDataStore
import com.cirodevs.indrverclonekotlin.data.remote.dataSource.remote.services.AuthService
import com.cirodevs.indrverclonekotlin.domain.model.AuthResponse
import com.cirodevs.indrverclonekotlin.domain.model.ErrorResponse
import com.cirodevs.indrverclonekotlin.domain.model.User
import com.cirodevs.indrverclonekotlin.domain.repository.AuthRepository
import com.cirodevs.indrverclonekotlin.domain.util.ErrorHelper
import com.cirodevs.indrverclonekotlin.domain.util.Resource
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl (private val authService: AuthService, private val localDataStore: LocalDataStore) : AuthRepository {
    override suspend fun login(email: String, password: String): Resource<AuthResponse>{
        return try {
            val  result = authService.login(email, password)
            if(result.isSuccessful){
                Log.d("AuthRepositoryImpl",  "Data: ${result.body()}")
                Resource.Success(result.body()!!) // doble admiracion por si viene null
            }else{
                Log.d("AuthRepositoryImpl",  "Error en la peticion")
                val errorResponse : ErrorResponse? = ErrorHelper.handleError(result.errorBody())
                // we passed the errorResponse to the Resource.Failure, in other wise we show the text "Error en la peticion"
                Resource.Failure( errorResponse?.message ?: "An unknown error occurred" )
            }
        }catch (e: Exception) {
            Log.d("AuthRepositoryImpl",  "Message: ${e}")
            Log.d("AuthRepositoryImpl",  "Message Cause: ${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message ?: "error DESCONOCIDO")

        }
    }

    override suspend fun register(user: User): Resource<AuthResponse> {
        return try {
            val  result = authService.register(user)
            if(result.isSuccessful){
                Log.d("AuthRepositoryImpl",  "Data: ${result.body()}")
                Resource.Success(result.body()!!) // doble admiracion por si viene null
            }else{
                Log.d("AuthRepositoryImpl",  "Error en la peticion")
                val errorResponse : ErrorResponse? = ErrorHelper.handleError(result.errorBody())
                // we passed the errorResponse to the Resource.Failure, in other wise we show the text "Error en la peticion"
                Resource.Failure( errorResponse?.message ?: "An unknown error occurred" )
            }
        }catch (e: Exception) {
            Log.d("AuthRepositoryImpl",  "Message: ${e}")
            Log.d("AuthRepositoryImpl",  "Message Cause: ${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message ?: "error DESCONOCIDO")

        }
    }
    // here we save the authResponse in the localDataStore
    override suspend fun saveSession(authResponse: AuthResponse) {
        localDataStore.save(authResponse)
    }
    // here we delete the authResponse in the localDataStore ( erase session)
    override suspend fun logout() {
        localDataStore.delete()
    }
    // here we get the authResponse in the localDataStore
    // also can be = in return localDataStore.getData()
    override fun getSessionData(): Flow<AuthResponse> {
       return localDataStore.getData()
    }

}