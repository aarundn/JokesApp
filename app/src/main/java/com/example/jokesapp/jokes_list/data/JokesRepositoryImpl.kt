package com.example.jokesapp.jokes_list.data

import com.example.jokesapp.jokes_list.domain.model.Joke
import com.example.jokesapp.jokes_list.domain.repos.JokesRepository
import com.example.jokesapp.jokes_list.domain.repos.JokesSourceIdentifier
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class JokesRepositoryImpl(override val identifier: JokesSourceIdentifier) : JokesRepository {
    override fun getJokes(): Flow<List<Joke>> {
        return flowOf(
            listOf(
                Joke(
                    id = 1,
                    title = "Chkara fi Taxi",
                    content = "Wahed rahi tahder m3a chauffeur taxi: 'Chofna chkara, matansa na7sba m3ana.'... repli chauffeur: 'Matkhafich, 3andi 3lah tsirwiya.' 😂"
                ),
                Joke(
                    id = 2,
                    title = "Yatla3 Yanhbet",
                    content = "Wahed labessah mezyan, galuh 'Wach edayer?' Galhum: 'Yatla3 yanhbet.' 😂"
                ),
                Joke(
                    id = 3,
                    title = "Nhar l’khyar",
                    content = "Wahed marra galou 'Wach rak?' Galhum: 'Nhar l’khyar ou ana khedma m3a l'chi2ar!' 😂"
                ),
                Joke(
                    id = 4,
                    title = "El We9ta",
                    content = "Wahed chehab les grands concepts, kima 'el we9ta', laysa 'el waqt'. 😂"
                ),
                Joke(
                    id = 5,
                    title = "Rassi darli Mode Avion",
                    content = "Wahed gal: 'Rassi darli Mode Avion, maymedch hadra!' 😂"
                )
            )
        )
    }
}