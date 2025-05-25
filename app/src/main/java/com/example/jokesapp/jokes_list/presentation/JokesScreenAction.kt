package com.example.jokesapp.jokes_list.presentation

sealed class JokesScreenAction {
    data object OnScreenClick : JokesScreenAction()
    data class  OnJokeClicked(val jokeId: String) : JokesScreenAction()
    data class ShowSnackBar(val message: String) : JokesScreenAction()
}