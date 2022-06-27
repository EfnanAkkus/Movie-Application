package com.example.movieapplication.domain.repository

import com.example.movieapplication.data.modal.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}