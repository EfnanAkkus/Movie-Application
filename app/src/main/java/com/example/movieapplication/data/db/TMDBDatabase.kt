package com.example.movieapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapplication.data.modal.artist.Artist
import com.example.movieapplication.data.modal.movie.Movie
import com.example.movieapplication.data.modal.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false )
abstract class TMDBDatabase : RoomDatabase(){
abstract fun movieDao(): MovieDao
abstract fun tvDao(): TvShowDao
abstract fun artistDao(): ArtistDao
}