package com.chivumarius.movieapp.data.datasourceImpl

import com.chivumarius.movieapp.data.api.TMDBService
import com.chivumarius.movieapp.data.datasource.MovieRemoteDataSource
import com.chivumarius.movieapp.data.model.MovieList
import retrofit2.Response


// ♦ This "Class" will "Connect"
//      → with the "MovieRemoteDataSource" Interface
//      → by "Extending" this "Class":
class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {

    // ♦ The "getMovies()" Method:
    override suspend fun getMovies(): Response<MovieList> =
        // ♦ Connecting "getMovies()" Method
        //      → with the "getPopularMovies()" Method:
        tmdbService.getPopularMovies(apiKey)
}