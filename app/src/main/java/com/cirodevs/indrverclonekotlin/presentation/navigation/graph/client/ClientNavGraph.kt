package com.cirodevs.indrverclonekotlin.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.cirodevs.indrverclonekotlin.presentation.navigation.Graph
import com.cirodevs.indrverclonekotlin.presentation.navigation.screen.auth.AuthScreen
import com.cirodevs.indrverclonekotlin.presentation.navigation.screen.client.ClientScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.login.LoginScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.register.ResgisterScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.client.home.ClientHomeScreen

fun NavGraphBuilder.ClientNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.CLIENT,
        startDestination = ClientScreen.Home.route
    ) {
        composable(route = ClientScreen.Home.route) {
            ClientHomeScreen(navHostController = navHostController) }

    }
}