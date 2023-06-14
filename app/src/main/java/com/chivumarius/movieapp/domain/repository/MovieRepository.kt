package com.chivumarius.movieapp.domain.repository

import com.chivumarius.movieapp.data.model.Movie



// ♦ The "interface MovieRepository {" Interface:
interface MovieRepository {

    // ♦ The "getMovies()" Function:
    suspend fun getMovies(): List<Movie>?

    // ♦ The "updateMovies()" Function:
    suspend fun updateMovies(): List<Movie>?
}