package com.cirodevs.indrverclonekotlin.domain.useCases.auth

import com.cirodevs.indrverclonekotlin.domain.repository.AuthRepository

class GetSessionDataUseCase(private val repository: AuthRepository) {
    // here isn't a suspend function because we using a flow
    operator fun invoke() = repository.getSessionData()
}