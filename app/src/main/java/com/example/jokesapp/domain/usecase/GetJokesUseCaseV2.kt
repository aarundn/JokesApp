package com.example.jokesapp.domain.usecase

import com.example.jokesapp.data.JokesSourceFactory
import com.example.jokesapp.domain.model.Joke
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetJokesUseCaseV2 @Inject constructor() {
    operator fun invoke(sourceId: String): Flow<List<Joke>> {
        val jokesSource = JokesSourceFactory.getSource(sourceId)
            ?: throw IllegalArgumentException("Unknown Source $sourceId")
        return jokesSource.getJokes()
    }
}