package com.cirodevs.indrverclonekotlin.presentation.navigation.screen.profile

sealed class ProfileScreen (val route: String) {
    object ProfileInfo : ProfileScreen(route = "/profile/info")
    object ProfileUpdate : ProfileScreen(route = "/profile/update/{user}"){

        fun passUser(user: String) = "/profile/update/${user}"

    }

}