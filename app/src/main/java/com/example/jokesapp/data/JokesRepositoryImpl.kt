package com.example.jokesapp.data

import com.example.jokesapp.domain.model.Jokes
import com.example.jokesapp.domain.repos.JokesRepository

class JokesRepositoryImpl : JokesRepository {
    override fun getJokes(): List<Jokes> {
        return listOf(
            Jokes(
                1,
                "Chkara fi Taxi",
                "Wahed rahi tahder m3a chauffeur taxi: 'Chofna chkara, matansa na7sba m3ana.'... repli chauffeur: 'Matkhafich, 3andi 3lah tsirwiya.' 😂"
            ),
            Jokes(
                2,
                "Yatla3 Yanhbet",
                "Wahed labessah mezyan, galuh 'Wach edayer?' Galhum: 'Yatla3 yanhbet.' 😂"
            ),
            Jokes(
                3,
                "Nhar l’khyar",
                "Wahed marra galou 'Wach rak?' Galhum: 'Nhar l’khyar ou ana khedma m3a l'chi2ar!' 😂"
            ),
            Jokes(
                4,
                "El We9ta",
                "Wahed chehab les grands concepts, kima 'el we9ta', laysa 'el waqt'. 😂"
            ),
            Jokes(
                5,
                "Rassi darli Mode Avion",
                "Wahed gal: 'Rassi darli Mode Avion, maymedch hadra!' 😂"
            )
        )
    }
}