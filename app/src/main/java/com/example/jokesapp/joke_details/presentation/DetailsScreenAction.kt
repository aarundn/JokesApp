package com.example.jokesapp.joke_details.presentation

sealed class DetailsScreenAction {
    data class OnScreenClick(val jokeId: String) : DetailsScreenAction()
    object OnRetryClick : DetailsScreenAction()
}