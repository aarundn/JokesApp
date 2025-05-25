package com.example.jokesapp.jokes_list.presentation

import com.example.jokesapp.jokes_list.domain.model.Joke

data class JokesStateV1(
    val isLoading: Boolean = false,
    val jokes: List<Joke> = emptyList(),
    val errorMessage: String? = null
)