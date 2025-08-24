package com.cirodevs.indrverclonekotlin.data.repository

import com.cirodevs.indrverclonekotlin.data.dataSource.local.datastore.LocalDataStore
import com.cirodevs.indrverclonekotlin.data.dataSource.remote.services.AuthService
import com.cirodevs.indrverclonekotlin.data.util.HandleRequest
import com.cirodevs.indrverclonekotlin.domain.model.AuthResponse
import com.cirodevs.indrverclonekotlin.domain.model.User
import com.cirodevs.indrverclonekotlin.domain.repository.AuthRepository
import com.cirodevs.indrverclonekotlin.domain.util.Resource
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl (private val authService: AuthService, private val localDataStore: LocalDataStore) : AuthRepository {
    override suspend fun login(email: String, password: String): Resource<AuthResponse> =
        HandleRequest.send(authService.login(email, password))


    override suspend fun register(user: User): Resource<AuthResponse> =
        HandleRequest.send(authService.register(user))



    // here we save the authResponse in the localDataStore
    override suspend fun saveSession(authResponse: AuthResponse) {
        localDataStore.save(authResponse)
    }

    override suspend fun updateSession(user: User) {
        localDataStore.update(user)
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