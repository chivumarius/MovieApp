package com.chivumarius.movieapp.presentation.dependencyinjection.module

import com.chivumarius.movieapp.data.datasource.MovieLocalDataSource
import com.chivumarius.movieapp.data.datasourceImpl.MovieLocalDataSourceImpl
import com.chivumarius.movieapp.data.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton



// ♦ This Class → will "Provide Us"
//      → the "MovieLocalDataSourceImpl Instance".
@Module     // ♦ "Annotation" → to "Act" as a "Module" for the "Class".
class LocalDataModule {

    @Singleton    // ♦ This "Annotation"  → is Used for "Only One Instance"  → of "MovieLocalDataSourceImpl"
    @Provides     // ♦ This "Annotation"  →  Provides us the "MovieLocalDataSourceImpl Instance".
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }
}