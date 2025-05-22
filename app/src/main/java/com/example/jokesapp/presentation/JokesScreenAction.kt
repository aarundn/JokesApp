package com.example.jokesapp.presentation

sealed class JokesScreenAction {
    data object OnScreenClick : JokesScreenAction()
}