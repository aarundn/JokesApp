package com.example.jokesapp.core.navigation

import kotlinx.serialization.Serializable

sealed interface  Destinations {
    @Serializable
    data object JokesList : Destinations
    @Serializable
    data class JokeDetails(val jokeId: String) : Destinations
}