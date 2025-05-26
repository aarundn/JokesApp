package com.example.jokesapp.joke_details.presentation

data class DetailsState(
    val isLoading: Boolean = false,
    val error: String = "",
    val joke: String = "",
)