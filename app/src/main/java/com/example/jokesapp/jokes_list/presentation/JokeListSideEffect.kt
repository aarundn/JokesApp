package com.example.jokesapp.jokes_list.presentation

sealed class JokeListSideEffect {
    data class NavigateToDetails(val jokeId: String) : JokeListSideEffect()
    data class ShowSnackBar(val message: String) : JokeListSideEffect()
}