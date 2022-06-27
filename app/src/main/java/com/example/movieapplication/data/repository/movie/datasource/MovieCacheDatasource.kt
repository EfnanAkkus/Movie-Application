package com.example.movieapplication.data.repository.movie.datasource

import com.example.movieapplication.data.modal.movie.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}