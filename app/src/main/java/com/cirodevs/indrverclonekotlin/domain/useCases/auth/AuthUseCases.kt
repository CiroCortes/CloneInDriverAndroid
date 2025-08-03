package com.cirodevs.indrverclonekotlin.domain.useCases.auth

import javax.inject.Inject

// this class will store all the use cases por auth


class AuthUseCases @Inject constructor (
    val login: LoginUseCase,
    val register: RegisterUseCase
)