package com.example.moviescoroutines.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val repository: MainRepository
    // val navController: NavController
) : ViewModel() {

    val filmesLiveData: MutableLiveData<List<Filme>> = MutableLiveData()

    fun getFilmes(){
        repository.getFilmes { filmes ->
            filmesLiveData.postValue(filmes)
        }
    }

    fun getFilmesCoroutine(){
        CoroutineScope(Dispatchers.Main).launch {
            var filmes = withContext(Dispatchers.Default) {
                repository.getFilmesCoroutine()
            }

            filmesLiveData.value = filmes
        }
    }

//    class MainViewModelFactory(
//        private val repository: MainRepository
//    ) : ViewModelProvider.Factory {
//        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            return modelClass.getConstructor(MainRepository::class.java).newInstance(repository)
//        }
//    }

}
