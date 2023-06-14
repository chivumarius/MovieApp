package com.chivumarius.movieapp.data.datasource

import com.chivumarius.movieapp.data.model.Movie

// ♦ We Allow the Application to Choose
//      → where it Takes the "Data Source"
//      → from "Remote", from "Local" Source ("Room")
//      → or from "Cache".
interface MovieLocalDataSource {
    // ♦ The "getMoviesFromDB()" Function:
    suspend fun getMoviesFromDB(): List<Movie>

    // ♦ The "saveMoviesToDB()" Function:
    suspend fun saveMoviesToDB(movies:List<Movie>)

    // ♦ The "clearAll()" Function:
    suspend fun clearAll()
}