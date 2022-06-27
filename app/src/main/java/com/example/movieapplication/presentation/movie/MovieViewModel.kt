package com.example.movieapplication.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapplication.domain.usecase.GetMoviesUseCase
import com.example.movieapplication.domain.usecase.UpdateMoviesUseCase
//eğer burada const. varsa viewmodelfactory class oluşturuyoruz
class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
):ViewModel() {

    fun getMovies()= liveData{
        val movieList=getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies()= liveData {
        val movieList=updateMoviesUseCase.execute()
        emit(movieList)
    }
}