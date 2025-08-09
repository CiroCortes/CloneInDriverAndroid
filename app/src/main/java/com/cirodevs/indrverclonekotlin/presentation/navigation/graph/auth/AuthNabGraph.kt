package com.cirodevs.indrverclonekotlin.presentation.navigation.graph.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.cirodevs.indrverclonekotlin.presentation.navigation.Graph
import com.cirodevs.indrverclonekotlin.presentation.navigation.screen.auth.AuthScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.login.LoginScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.register.ResgisterScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.client.home.ClientHomeScreen

fun NavGraphBuilder.AuthNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) { LoginScreen(navHostController) }
        composable(route = AuthScreen.Register.route) { ResgisterScreen(navHostController) }
        composable(route = Graph.CLIENT) { ClientHomeScreen() }


    }
}