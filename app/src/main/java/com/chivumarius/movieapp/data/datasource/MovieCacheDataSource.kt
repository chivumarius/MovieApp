package com.chivumarius.movieapp.data.datasource

import com.chivumarius.movieapp.data.model.Movie


// ♦ We Allow the Application to Choose
//      → where it Takes the "Data Source"
//      → from "Remote", from "Local" Source ("Room")
//      → or from "Cache".
interface MovieCacheDataSource {

    // ♦ The "getMoviesFromCache()" Function:
    suspend fun getMoviesFromCache(): List<Movie>

    // ♦ The "saveMoviesToCache()" Function:
    suspend fun saveMoviesToCache(movies:List<Movie>)
}