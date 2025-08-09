package com.cirodevs.indrverclonekotlin.presentation.navigation.screen.client

sealed class ClientScreen(val route: String) {
    object Home : ClientScreen("/client/home")
    object ProfileInfo : ClientScreen("/client/profile/info")
    object MapSearcher : ClientScreen("/client/map/searcher")

}