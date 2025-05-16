package com.example.jokesapp.data

import com.example.jokesapp.domain.model.Joke
import com.example.jokesapp.domain.repos.JokesRepository
import com.example.jokesapp.domain.repos.JokesSourceIdentifier
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class EgyptianJokesRepositoryImpl(override val identifier: JokesSourceIdentifier) :
    JokesRepository {
    override fun getJokes(): Flow<List<Joke>> {
        return flowOf(
            listOf(
                Joke(
                    id = 1,
                    title = "Pyramid Scheme",
                    content = "Why couldn't the mummy attend the pyramid scheme meeting? He was too wrapped up in his work!"
                ),
                Joke(
                    id = 2,
                    title = "Ancient Wi-Fi",
                    content = "Why did the ancient Egyptians have excellent Wi-Fi? Because they were experts at building hotspots with their pyramids!"
                ),
                Joke(
                    id = 3,
                    title = "Sphinx Riddle",
                    content = "What did the Sphinx say to the tourist? Nothing, it just kept its secrets to itself!"
                ),
                Joke(
                    id = 4,
                    title = "Mummy's Day Off",
                    content = "What does a mummy do on his day off? He unwinds!"
                ),
                Joke(
                    id = 5,
                    title = "Pharaoh's Diet",
                    content = "Why don't pharaohs ever get fat? Because they watch their caloric intake-they're always on de-Nile!"
                ),
                Joke(
                    id = 6,
                    title = "Cleopatra's Phone",
                    content = "What was Cleopatra's favorite app? Snapsphinx!"
                ),
                Joke(
                    id = 7,
                    title = "Egyptian Uber",
                    content = "What do you call an Egyptian Uber? A Cairo-ride!"
                ),
                Joke(
                    id = 8,
                    title = "Tutankhamun's Music",
                    content = "What kind of music did King Tut like? Wrap music!"
                )
            )
        )
    }
}