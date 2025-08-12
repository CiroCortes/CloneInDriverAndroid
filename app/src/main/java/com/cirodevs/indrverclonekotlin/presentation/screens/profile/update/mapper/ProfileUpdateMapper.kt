package com.cirodevs.indrverclonekotlin.presentation.screens.profile.update.mapper

import com.cirodevs.indrverclonekotlin.domain.model.User
import com.cirodevs.indrverclonekotlin.presentation.screens.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser() : User {
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        image = image
    )
}