package com.example.appmovie.data.local

import com.example.appmovie.data.model.Movie
import com.example.appmovie.data.model.MovieEntity
import com.example.appmovie.data.model.MovieList
import com.example.appmovie.data.model.toMovieList
import com.example.appmovie.utils.AppConstants

class LocalMovieDataSource(private val movieDao: MovieDao) {

    suspend fun getUpcomingMovies(): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type == "upcoming" }.toMovieList()
    }


    suspend fun getTopRatedMovies(): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type == "toprated" }.toMovieList()
    }


    suspend fun getPopularMovies(): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type == "popular" }.toMovieList()
    }

    suspend fun saveMovie(movie: MovieEntity){
        movieDao.saveMovie(movie)
    }

}