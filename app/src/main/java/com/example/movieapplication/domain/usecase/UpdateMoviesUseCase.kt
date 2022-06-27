package com.example.movieapplication.domain.usecase

import com.example.movieapplication.data.modal.movie.Movie
import com.example.movieapplication.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? =movieRepository.updateMovies()
}