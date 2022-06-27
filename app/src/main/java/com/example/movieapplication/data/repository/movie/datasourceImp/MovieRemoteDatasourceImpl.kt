package com.example.movieapplication.data.repository.movie.datasourceImp

import com.example.movieapplication.data.api.TMDBService
import com.example.movieapplication.data.modal.movie.MovieList
import com.example.movieapplication.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}