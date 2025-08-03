package com.cirodevs.indrverclonekotlin.presentation.screens.auth.register.mapper

import com.cirodevs.indrverclonekotlin.domain.model.User
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.register.RegisterState

fun RegisterState.toUser() : User {
    return User(
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        password = password,

    )
}