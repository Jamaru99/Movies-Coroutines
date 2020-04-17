package com.example.moviescoroutines.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {
    fun getFilmes(callback: (filme: List<Filme>) -> Unit) {
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Filme(id = 1, titulo = "senhor das patas"),
                    Filme(id = 2, titulo = "senhora das carnes")
                )
            )
        }).start()
    }

    suspend fun getFilmesCoroutine(): List<Filme> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            listOf(
                Filme(id = 1, titulo = "senhor das patas"),
                Filme(id = 2, titulo = "senhora das carnes")
            )
        }
    }
}