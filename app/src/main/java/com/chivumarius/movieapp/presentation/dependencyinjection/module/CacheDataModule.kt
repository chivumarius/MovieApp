package com.chivumarius.movieapp.presentation.dependencyinjection.module

import com.chivumarius.movieapp.data.datasource.MovieCacheDataSource
import com.chivumarius.movieapp.data.datasourceImpl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


// ♦ This Class → will "Provide Us"
//      → the "MovieCacheDataSourceImpl Instance".
@Module     // ♦ "Annotation" → to "Act" as a "Module" for the "Class".
class CacheDataModule {

    @Singleton      // ♦ This "Annotation"  → is Used for "Only One Instance"  → of "MovieCacheDataSourceImpl"
    @Provides       // ♦ This "Annotation" → Provides us the "MovieCacheDataSourceImpl Instance".
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }
}