package com.example.movieapplication.data.repository.movie.datasource

import com.example.movieapplication.data.modal.movie.Movie

interface MovieLocalDatasource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}