package com.chivumarius.movieapp.presentation.dependencyinjection.module

import android.content.Context
import androidx.room.Room
import com.chivumarius.movieapp.data.db.MovieDao
import com.chivumarius.movieapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


// ♦ This "Class" will "Provide" Us
//      → the "Room Database Instance".
@Module  // ♦ This "Annotation" → to "Act" as a "Module" for the "Class".
class DatabaseModule {

    @Singleton  // ♦ This "Annotation" → is Used for "Only One Instance" → of "Room Database".
    @Provides   // ♦ This "Annotation" → Provides us the "TMDBDatabase Instance" ("Room Database")
    fun provideMovieDatabase(context: Context): TMDBDatabase{
        return Room.databaseBuilder(context,
            TMDBDatabase::class.java,
            "tmdbclient").build()
    }

    // ♦ Providing the "TMDBDatabase" Instance.
    @Singleton
    @Provides
    fun provideMovieDAO(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }
}