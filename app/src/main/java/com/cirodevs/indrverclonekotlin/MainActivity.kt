package com.cirodevs.indrverclonekotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cirodevs.indrverclonekotlin.presentation.navigation.graph.root.RootNavGraph
import com.cirodevs.indrverclonekotlin.ui.theme.InDriverCloneKotlinTheme
import com.google.android.libraries.places.api.Places
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(!Places.isInitialized()){
            Places.initialize(this,getString(R.string.google_maps_api_key))
        }
        enableEdgeToEdge()

        setContent {
            InDriverCloneKotlinTheme {
                Surface {
                    navController = rememberNavController()
                    RootNavGraph(navHostController = navController)
                }
            }
        }
    }
}

