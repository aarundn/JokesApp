package com.example.jokesapp.jokes_list.presentation

import com.example.jokesapp.jokes_list.domain.model.Joke

sealed class JokesState {
    data object Loading : JokesState()
    data class Success(val jokes: List<Joke>) : JokesState()
    data class Error(val message: String) : JokesState()
}
