package com.cirodevs.indrverclonekotlin.presentation.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.cirodevs.indrverclonekotlin.presentation.navigation.Graph
import com.cirodevs.indrverclonekotlin.presentation.navigation.screen.auth.AuthScreen
import com.cirodevs.indrverclonekotlin.presentation.navigation.screen.profile.ProfileScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.login.LoginScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.register.ResgisterScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.client.home.ClientHomeScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.profile.info.ProfileInfoScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.profile.update.ProfileUpdateScreen

fun NavGraphBuilder.ProfileNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.PROFILE,
        startDestination = ProfileScreen.ProfileInfo.route
    ) {
        composable(route = ProfileScreen.ProfileInfo.route) { ProfileInfoScreen(navHostController) }
        composable(
            route = ProfileScreen.ProfileUpdate.route,
            arguments = listOf(
                navArgument("user") {
                    type = NavType.StringType

                })
        ) {
            it.arguments?.getString("user")?.let { user ->
                ProfileUpdateScreen(navHostController = navHostController, userParam = user)
            }
        }
    }
}