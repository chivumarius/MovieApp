package com.chivumarius.movieapp.data.api

import com.chivumarius.movieapp.data.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//  ♦ The "TMDBService" Interface
interface TMDBService {

    // ♦ Getting "ENDPOINT URL" from the  "Link"
    @GET("movie/popular")
    suspend fun getPopularMovies(
        // ♦ The "Query API Key"
        @Query( "api_key" ) apiKey: String

    // ♦ "Retrofit"
    //      → returns a "Response" Object
    //      → that will be an "Array" of "MovieList" Movies:
    ) : Response<MovieList>
}