package com.chivumarius.movieapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chivumarius.movieapp.domain.usecases.GetMoviesUseCase
import com.chivumarius.movieapp.domain.usecases.UpdateMoviesUseCase

// ♦ The  "ViewModelFactory" Class
//      → in which we are "Dealing" with "Use Cases"
//      → Extend the "ViewModelProvider.Factory" Object:
class ViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
    ) : ViewModelProvider.Factory {


    // ♦ The "create()" Method
    //      → which is a "Template":
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // ♦ Returning:
        return MyViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }
}