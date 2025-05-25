package com.example.jokesapp.core

interface AppCoordinator {

    fun navigateToJokesList()

    fun navigateToJokeDetails(jokeId: String)

    fun navigateBack()
}