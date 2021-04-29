package com.example.appmovie.ui.movie.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appmovie.core.BaseConcatHolder
import com.example.appmovie.databinding.PopularMoviesRowBinding
import com.example.appmovie.ui.movie.adapters.MovieAdapter

class PopularConcatAdapter(private val moviesAdapter: MovieAdapter) :
    RecyclerView.Adapter<BaseConcatHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding =
            PopularMoviesRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(moviesAdapter)
        }
    }

    private inner class ConcatViewHolder(val bindig: PopularMoviesRowBinding):BaseConcatHolder<MovieAdapter>(bindig.root) {
        override fun bind(adapter: MovieAdapter) {
            bindig.rvPopularMovies.adapter = adapter
        }
    }

}