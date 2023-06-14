package com.chivumarius.movieapp.data.datasourceImpl

import com.chivumarius.movieapp.data.datasource.MovieCacheDataSource
import com.chivumarius.movieapp.data.model.Movie


// ♦ This "Class" will "Connect"
//      → with the "MovieCacheDataSource" Interface
//      → by "Extending" this "Class":
class MovieCacheDataSourceImpl : MovieCacheDataSource {
    // ♦ Creating the "List" of "<ovies"
    //      → in which to "Store" the "Movies":
    private var movieList = ArrayList<Movie>()


    // ♦ The "getMoviesFromCache()" Method:
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }


    // ♦ The "saveMoviesToCache()" Method:
    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        // ♦ Clearing All List Items:
        movieList.clear()
        // ♦ "Saving" the "Movies" in the "Cache":
        movieList = ArrayList(movies)
    }
}