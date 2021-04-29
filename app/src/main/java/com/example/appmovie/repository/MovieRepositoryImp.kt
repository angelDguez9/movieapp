package com.example.appmovie.repository

import com.example.appmovie.core.InternetCheck
import com.example.appmovie.data.local.LocalMovieDataSource
import com.example.appmovie.data.model.MovieList
import com.example.appmovie.data.model.toMovieEntity
import com.example.appmovie.data.remote.RemoteMovieDataSource

class MovieRepositoryImp(
    private val dataSourceRemote: RemoteMovieDataSource,
    private val dataSourceLocal: LocalMovieDataSource
) : MovieRepository {


    override suspend fun getUpcomingMovies(): MovieList {
        return if (InternetCheck.isNetworkAvailable()){
            dataSourceRemote.getUpcomingMovies().results.forEach {
                dataSourceLocal.saveMovie(it.toMovieEntity("upcoming"))
            }
            dataSourceLocal.getUpcomingMovies()
        }else{
            dataSourceLocal.getUpcomingMovies()
        }
    }

    override suspend fun getTopRatedMovies(): MovieList {
        return if (InternetCheck.isNetworkAvailable()){
            dataSourceRemote.getTopRatedMovies().results.forEach {
                dataSourceLocal.saveMovie(it.toMovieEntity("toprated"))
            }
            dataSourceLocal.getTopRatedMovies()
        }else{
            dataSourceLocal.getTopRatedMovies()
        }

    }

    override suspend fun getPopularMovies(): MovieList {
        return if (InternetCheck.isNetworkAvailable()){
            dataSourceRemote.getPopularMovies().results.forEach {
                dataSourceLocal.saveMovie(it.toMovieEntity("popular"))
            }
            dataSourceLocal.getPopularMovies()
        }else{
            dataSourceLocal.getPopularMovies()
        }

    }
}