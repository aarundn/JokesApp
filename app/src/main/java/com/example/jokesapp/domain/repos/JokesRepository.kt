package com.example.jokesapp.domain.repos

import com.example.jokesapp.domain.model.Joke
import kotlinx.coroutines.flow.Flow

interface JokesRepository {
    val identifier: JokesSourceIdentifier
    fun getJokes(): Flow<List<Joke>>
}