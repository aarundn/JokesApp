package com.example.jokesapp.presentation

import com.example.jokesapp.domain.model.Joke

sealed class JokesState {
    data object Loading : JokesState()
    data class Success(val jokes: List<Joke>) : JokesState()
    data class Error(val message: String) : JokesState()
}
