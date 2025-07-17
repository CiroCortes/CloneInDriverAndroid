package com.cirodevs.indrverclonekotlin.presentation.navigation.graph.root

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.cirodevs.indrverclonekotlin.presentation.navigation.Graph
import com.cirodevs.indrverclonekotlin.presentation.navigation.graph.auth.AuthNavGraph

@Composable
fun RootNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ){
        AuthNavGraph(navHostController)
    }
}