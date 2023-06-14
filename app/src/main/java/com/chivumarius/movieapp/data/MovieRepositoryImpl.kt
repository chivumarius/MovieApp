package com.chivumarius.movieapp.data

import com.chivumarius.movieapp.data.datasource.MovieCacheDataSource
import com.chivumarius.movieapp.data.datasource.MovieLocalDataSource
import com.chivumarius.movieapp.data.datasource.MovieRemoteDataSource
import com.chivumarius.movieapp.data.model.Movie
import com.chivumarius.movieapp.domain.repository.MovieRepository


// ♦ This "Class" will be "Connected" with the "Domain Layer"
//      → through the "MovieRepository" Interface
//      → from the "domain/ repository" Package:
class MovieRepositoryImpl(
        private val movieRemoteDataSource: MovieRemoteDataSource,
        private val movieLocalDataSource: MovieLocalDataSource,
        private val movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

    // ♦ The "getMovies()" Method:
    override suspend fun getMovies(): List<Movie>? {
        // ♦ Returning the Method:
        return getMoviesFromCache()
    }


    // ♦ The "updateMovies()" Method:
    override suspend fun updateMovies(): List<Movie>? {
        // ♦ Getting "Movies" from "API":
        val newListOfMovies = getMoviesFromAPI()

        // ♦ Initialize "movieLocalDataSource"
        //      → and "Cleaning All"
        //      → when Calling the "updateMovies()" Method:
        movieLocalDataSource.clearAll()

        // ♦ Initialize "movieLocalDataSource"
        //      → and "Saving Movies"
        //      → to the "Local Db":
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)

        // ♦ Initialize "movieCacheDataSource"
        //      → and "Saving Movies"
        //      → to the "Cache":
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)

        return newListOfMovies
    }

    

    // ♦ The "getMoviesFromAPI()" Method
    //      → will Return a "List" of "Movie":
    suspend fun getMoviesFromAPI(): List<Movie> {
        // ♦ Variable Declaration:
        lateinit var movieList: List<Movie>

        // ♦ "Getting" and "Connecting" the "Data"
        //      → from the "Retrofit" Library:
        try {
            // ♦ Getting the "Movies" from "movieRemoteDataSource"
            //      → and Stored in the "Response" Object:
            val response = movieRemoteDataSource.getMovies()
            // ♦ Setting a "body" Object
            //      → and Calling the ".body()" Method
            //      → from the "Response"
            val body = response.body()

            // ♦ Checking: if "body" is Not "Null"/"Empty":
            if (body != null){
                // ♦ Getting the "Movies" from the "Body":
                movieList = body.movies
            }

        } catch (exception: java.lang.Exception) {
        }
        return movieList
    }


    // ♦ The "getMoviesFromROOM()" Method
    //      → will Return a "List" of "Movie":
    private suspend fun getMoviesFromROOM(): List<Movie>{
        // ♦ Variable Declaration:
        lateinit var movieList: List<Movie>

        // ♦ "Getting" and "Connecting" the "Data"
        //      → from the "Local Storage" Library:
        try {
            // ♦ Getting the "Movies From DB"
            //      → from the "Movie Local Data Source"
            //      → and Stored in the "movieList" Object:
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception: Exception){
        }

        // ♦ Checking: If there is a "Movie" in the "movieList":
        if (movieList.size > 0){
            return movieList
        } else {
            // ♦ Getting the "Movies" from "API":
            movieList = getMoviesFromAPI()
            // ♦ Saving the "movieList" in the "Movies DB":
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }


    // ♦ The "getMoviesFromCache()" Method
    //      → will Return a "List" of "Movie":
    private suspend fun getMoviesFromCache(): List<Movie>? {
        // ♦ Variable Declaration:
        lateinit var movieList : List<Movie>

        try {
            // ♦ Getting the "Movies From Cache"
            //      → from the "Movie Cache Data Source"
            //      → and Stored in the "movieList" Object:
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception : Exception) {
        }

        // ♦ Checking: If there is a "Movie" in the "movieList":
        if (movieList.size > 0 ) {
            return movieList
        } else {
            // ♦ Getting the "Movies" from "ROOM":
            movieList = getMoviesFromROOM()
            // ♦ Saving the "movieList" to the "Movies Cache":
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}