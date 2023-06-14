package com.chivumarius.movieapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chivumarius.movieapp.data.model.Movie

// ♦ The "MovieDao" Interface
//      → will Acts as a "DAO" ("Data Access Object")
@Dao
interface MovieDao {

    //  ♦ The "saveMovies()" Function
    //      → that will be "Executed" in the "Background":
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    //  ♦ The "deleteAllMovies()" Function
    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    //  ♦ The "getMovies()" Function
    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies(): List<Movie>
}