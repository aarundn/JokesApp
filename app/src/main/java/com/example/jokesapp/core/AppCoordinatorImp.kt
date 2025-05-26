package com.example.jokesapp.core


import androidx.navigation.NavHostController
import com.example.jokesapp.core.navigation.Destinations

class AppCoordinatorImp(
    private val navController: NavHostController
): AppCoordinator {

    override fun navigateToJokesList() {
        navController.navigate(Destinations.JokesList)
    }

    override fun navigateToJokeDetails(jokeId: String) {
        navController.navigate(Destinations.JokeDetails(jokeId))
    }

    override fun navigateBack() {
        if (navController.previousBackStackEntry != null) {
            navController.popBackStack()
        }
    }
}