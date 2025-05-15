package com.example.jokesapp.domain.usecase

import com.example.jokesapp.domain.model.Jokes
import com.example.jokesapp.domain.repos.JokesRepository
import javax.inject.Inject

class GetJokesUseCase @Inject constructor(
    private val jokesRepository: JokesRepository
) {
    fun execute(): List<Jokes> {
        return jokesRepository.getJokes()
    }
}