package com.cirodevs.indrverclonekotlin.domain.useCases.auth

import com.cirodevs.indrverclonekotlin.domain.model.AuthResponse
import com.cirodevs.indrverclonekotlin.domain.repository.AuthRepository

class SaveSessionUseCase (private val repository: AuthRepository) {
    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)
}