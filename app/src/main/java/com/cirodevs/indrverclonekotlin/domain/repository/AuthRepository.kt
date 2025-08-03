package com.cirodevs.indrverclonekotlin.domain.repository

import com.cirodevs.indrverclonekotlin.domain.model.AuthResponse
import com.cirodevs.indrverclonekotlin.domain.model.User
import com.cirodevs.indrverclonekotlin.domain.util.Resource

interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<AuthResponse>
    suspend fun register(user : User): Resource<AuthResponse>
}