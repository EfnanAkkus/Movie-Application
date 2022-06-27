package com.example.movieapplication.data.repository.movie.datasource

import com.example.movieapplication.data.modal.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}