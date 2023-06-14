package com.chivumarius.movieapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.chivumarius.movieapp.domain.usecases.GetMoviesUseCase
import com.chivumarius.movieapp.domain.usecases.UpdateMoviesUseCase

// ♦ The  "MyViewModel" Class
//      → in which we are "Dealing" with "Use Cases"
//      → Extend the "ViewModel":
class MyViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
    ) : ViewModel() {

    // ♦ The "getMovies()" Method
    //      → for Getting te "liveData"
    //      → and "Storing" them in the "movieList":
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }


    // ♦ The "updateMovies()" Method:
    //      → for Getting te "liveData"
    //      → and "Storing" them in the "movieList":
    fun updateMovies()  = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}