package com.cirodevs.indrverclonekotlin.domain.useCases.auth

import com.cirodevs.indrverclonekotlin.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}