package com.chivumarius.movieapp.presentation.dependencyinjection.module

import com.chivumarius.movieapp.domain.repository.MovieRepository
import com.chivumarius.movieapp.domain.usecases.GetMoviesUseCase
import com.chivumarius.movieapp.domain.usecases.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides

// ♦ This Class → will "Provide Us"
//      → the "GetMoviesUseCase Instance" and
//      → the "UpdateMoviesUseCase Instance".
@Module     // ♦ "Annotation" → to "Act" as a "Module" for the "Class".
class UseCaseModule {

    @Provides    // ♦ This "Annotation" → Provides us the "GetMoviesUseCase Instance".
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides   // ♦ This "Annotation" → Provides us the "UpdateMoviesUseCase Instance".
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }
}