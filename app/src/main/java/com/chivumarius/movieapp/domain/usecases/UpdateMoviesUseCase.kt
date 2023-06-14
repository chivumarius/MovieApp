package com.chivumarius.movieapp.domain.usecases

import com.chivumarius.movieapp.data.model.Movie
import com.chivumarius.movieapp.domain.repository.MovieRepository


// ♦ The "Use Cases"
//      → will "Always Connect" with the "Repository":
class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    // ♦ The "execute()" Method:
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}