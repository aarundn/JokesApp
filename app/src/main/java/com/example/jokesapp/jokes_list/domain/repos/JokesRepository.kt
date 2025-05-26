package com.example.jokesapp.jokes_list.domain.repos

import com.example.jokesapp.jokes_list.domain.model.Joke
import kotlinx.coroutines.flow.Flow

interface JokesRepository {
    val identifier: JokesSourceIdentifier
    fun getJokes(): Flow<List<Joke>>
}