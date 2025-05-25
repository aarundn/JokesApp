package com.example.jokesapp.jokes_list.domain.usecase

import com.example.jokesapp.jokes_list.domain.repos.JokesRepository
import javax.inject.Inject

class GetJokesUseCase @Inject constructor(
    private val jokesRepository: JokesRepository
) {
    operator fun invoke() = jokesRepository.getJokes()
}