package com.example.movieapplication.data.api

import com.example.movieapplication.data.modal.movie.MovieList
import com.example.movieapplication.data.modal.artist.ArtistList
import com.example.movieapplication.data.modal.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey:String):Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShow(@Query("api_key")apiKey:String):Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(@Query("api_key")apiKey:String):Response<ArtistList>


}