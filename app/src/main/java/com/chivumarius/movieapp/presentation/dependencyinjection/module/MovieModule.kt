package com.chivumarius.movieapp.presentation.dependencyinjection.module

import com.chivumarius.movieapp.domain.usecases.GetMoviesUseCase
import com.chivumarius.movieapp.domain.usecases.UpdateMoviesUseCase
import com.chivumarius.movieapp.presentation.dependencyinjection.MovieScope
import com.chivumarius.movieapp.presentation.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides

// ♦ This Class → will "Provide Us"
//      → the "ViewModelFactory Instance".
@Module     // ♦ "Annotation" → to "Act" as a "Module" for the "Class".
class MovieModule {
    @MovieScope
    @Provides   // ♦ This "Annotation" → Provides us the "ViewModelFactory Instance".
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): ViewModelFactory {

        return ViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}