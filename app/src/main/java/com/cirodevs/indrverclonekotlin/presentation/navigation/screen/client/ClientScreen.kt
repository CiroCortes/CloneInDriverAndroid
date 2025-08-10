package com.cirodevs.indrverclonekotlin.presentation.navigation.screen.client

sealed class ClientScreen(val route: String) {

    object MapSearcher : ClientScreen("/client/map/searcher")

}