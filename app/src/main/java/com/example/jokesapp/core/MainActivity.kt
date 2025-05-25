package com.example.jokesapp.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.jokesapp.core.navigation.Destinations.JokesList
import com.example.jokesapp.core.navigation.MainNavHost
import com.example.jokesapp.core.theme.JokesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JokesAppTheme {
                val jokesNavController = rememberNavController()
                Scaffold { paddingValues ->
                    MainNavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        startDestination = JokesList,
                        navController = jokesNavController
                    )
                }

            }
        }
    }
}