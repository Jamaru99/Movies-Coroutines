package com.example.moviescoroutines.di

import com.example.moviescoroutines.ui.main.MainRepository
import com.example.moviescoroutines.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import androidx.navigation.NavController

val mainModule = module {

    factory {
        MainRepository()
    }

    viewModel { //(navController: NavController) ->
        MainViewModel(
            repository = get()
            //navController = navController
        )
    }

}