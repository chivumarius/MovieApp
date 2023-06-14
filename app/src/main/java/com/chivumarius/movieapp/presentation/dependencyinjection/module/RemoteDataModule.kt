package com.chivumarius.movieapp.presentation.dependencyinjection.module

import com.chivumarius.movieapp.data.api.TMDBService
import com.chivumarius.movieapp.data.datasource.MovieRemoteDataSource
import com.chivumarius.movieapp.data.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


// ♦ The "RemoteDataModule" Class
//      → will "Provide us"
//      → with the "MovieRemoteDataSourceImpl Instance".
@Module     // ♦ "Annotation" → to "Act" as a "Module" for the "Class":
class RemoteDataModule(private val apiKey: String) {





    @Singleton    // ♦ This "Annotation" → is Used for "Only One Instance" → of "Room Database"
    @Provides    // ♦ This "Annotation" → Provides us the "MovieRemoteDataSourceImpl Instance".
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService,
            apiKey
        )
    }
}