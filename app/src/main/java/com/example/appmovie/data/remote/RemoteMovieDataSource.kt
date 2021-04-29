package com.example.appmovie.data.remote

import com.example.appmovie.data.model.MovieList
import com.example.appmovie.repository.WebServices
import com.example.appmovie.utils.AppConstants

class RemoteMovieDataSource(private val webServices: WebServices) {


    suspend fun getUpcomingMovies(): MovieList = webServices.getUpcomingMovies(AppConstants.API_KEY)


    suspend fun getTopRatedMovies(): MovieList = webServices.getTopRatedMovies(AppConstants.API_KEY)


    suspend fun getPopularMovies(): MovieList = webServices.getPopularMovies(AppConstants.API_KEY)

}