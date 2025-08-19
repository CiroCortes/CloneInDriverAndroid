package com.cirodevs.indrverclonekotlin.domain.useCases.auth

import com.cirodevs.indrverclonekotlin.domain.model.User
import com.cirodevs.indrverclonekotlin.domain.repository.AuthRepository

class UpdateSessionUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(user: User) = repository.updateSession(user)
}