package com.chivumarius.movieapp.data.datasource

import com.chivumarius.movieapp.data.model.MovieList
import retrofit2.Response


// ♦ We Allow the Application to Choose
//      → where it Takes the "Data Source"
//      → from "Remote", from "Local" Source ("Room")
//      → or from "Cache".
interface MovieRemoteDataSource {
    // ♦ The "getMovies()" function:
    suspend fun getMovies() : Response<MovieList>
}