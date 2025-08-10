package com.cirodevs.indrverclonekotlin.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.cirodevs.indrverclonekotlin.presentation.navigation.Graph
import com.cirodevs.indrverclonekotlin.presentation.navigation.graph.profile.ProfileNavGraph
import com.cirodevs.indrverclonekotlin.presentation.navigation.screen.auth.AuthScreen
import com.cirodevs.indrverclonekotlin.presentation.navigation.screen.client.ClientScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.login.LoginScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.auth.register.ResgisterScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.client.home.ClientHomeScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.client.mapSearcher.ClientMapSearcherScreen
import com.cirodevs.indrverclonekotlin.presentation.screens.profile.info.ProfileInfoScreen

@Composable
fun ClientNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.MapSearcher.route
    ) {
        composable(route = ClientScreen.MapSearcher.route) {
            ClientMapSearcherScreen(
                navHostController = navHostController
            )
        }
        ProfileNavGraph(navHostController)
    }
}