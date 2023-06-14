package com.chivumarius.movieapp.presentation.dependencyinjection.module

import com.chivumarius.movieapp.data.MovieRepositoryImpl
import com.chivumarius.movieapp.data.datasource.MovieCacheDataSource
import com.chivumarius.movieapp.data.datasource.MovieLocalDataSource
import com.chivumarius.movieapp.data.datasource.MovieRemoteDataSource
import com.chivumarius.movieapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton



// ♦ This Class → will "Provide Us"
//      → the "MovieRepositoryImpl Instance".
@Module     // ♦ "Annotation" → to "Act" as a "Module" for the "Class".
class RepositoryModule {

    @Singleton      // ♦ This "Annotation"  → is Used for "Only One Instance"  → of "MovieRepositoryImpl"
    @Provides       // ♦ This "Annotation" → Provides us the "MovieRepositoryImpl Instance".
    fun provideMovieRepository(
            movieRemoteDataSource: MovieRemoteDataSource,
            movieLocalDataSource: MovieLocalDataSource,
            movieCacheDataSource: MovieCacheDataSource
        ): MovieRepository {

        return MovieRepositoryImpl(
                movieRemoteDataSource,
                movieLocalDataSource,
                movieCacheDataSource
            )
    }
}