package com.example.jokesapp.domain.repos

import com.example.jokesapp.domain.model.Jokes

interface JokesRepository {
    fun getJokes(): List<Jokes>
}