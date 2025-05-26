package com.example.jokesapp.core.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jokesapp.core.AppCoordinator
import com.example.jokesapp.core.AppCoordinatorImp
import com.example.jokesapp.core.navigation.Destinations.JokeDetails
import com.example.jokesapp.core.navigation.Destinations.JokesList
import com.example.jokesapp.joke_details.presentation.DetailsScreen
import com.example.jokesapp.jokes_list.presentation.JokesScreenRout

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    startDestination: Destinations,
    navController:NavHostController
) {

    val coordinator: AppCoordinator = remember(navController) {
        AppCoordinatorImp(navController)
    }
    val snackBarHostState = remember { SnackbarHostState() }

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ){
        composable<JokesList> {
            JokesScreenRout(
                modifier = modifier,
                coordinator = coordinator,
                showSnackBar = snackBarHostState
            )
        }
        composable<JokeDetails> { backStackEntry ->
            val jokeId = backStackEntry.arguments?.getString("jokeId")
                DetailsScreen(modifier = modifier, jokeId = jokeId)
        }
    }
}