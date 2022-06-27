package com.example.movieapplication.data.repository.movie.datasourceImp

import com.example.movieapplication.data.modal.movie.Movie
import com.example.movieapplication.data.repository.movie.datasource.MovieCacheDatasource

class MovieCacheDatasourceImpl : MovieCacheDatasource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList= ArrayList(movies)
    }
}