package com.cirodevs.indrverclonekotlin.domain.useCases.auth

import com.cirodevs.indrverclonekotlin.domain.repository.AuthRepository

class LogoutUseCse(private val repository: AuthRepository) {
    suspend operator fun invoke() = repository.logout()
}