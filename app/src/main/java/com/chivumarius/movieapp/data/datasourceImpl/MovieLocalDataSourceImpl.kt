package com.chivumarius.movieapp.data.datasourceImpl

import com.chivumarius.movieapp.data.datasource.MovieLocalDataSource
import com.chivumarius.movieapp.data.db.MovieDao
import com.chivumarius.movieapp.data.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



// ♦ This "Class" will "Connect"
//      → with the "MovieLocalDataSource" Interface
//      → by "Extending" this "Class":
class MovieLocalDataSourceImpl(private val movieDao: MovieDao): MovieLocalDataSource {
    // ♦ The "getMoviesFromDB()" Method
    //      → "Connected" with "movieDao"::
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }


    // ♦ The "saveMoviesToDB()" Method
    //      → "Connected" with "movieDao"::
    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        // ♦♦ USING "COROUTINES" ♦♦
        // ♦ The "Dispatcher"
        //      → Allows "Thread Selection"
        // ♦ The ".IO"
        //      → is "Design" for "Offloading" the "Blocking IO Tasks"
        //      → to a "Shared Thread Pool"
        //      → and "Network Operations".
        CoroutineScope(Dispatchers.IO).launch {
            // ♦ Calling the "movieDao"
            //      → and "Saving" the "Movies" in the "Database":
            movieDao.saveMovies(movies)
        }
    }


    // ♦ The "clearAll()" Method
    //      → "Connected" with "movieDao"::
    override suspend fun clearAll() {
        // ♦♦ USING "COROUTINES" ♦♦
        CoroutineScope(Dispatchers.IO).launch {
            // ♦ Calling the "movieDao"
            //      → and "Deleting All" the "Movies" from the "Database":
            movieDao.deleteAllMovies()
        }
    }

}