package com.example.appmovie.ui.moviedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.appmovie.R
import com.example.appmovie.databinding.FragmentMovieDeailBinding


class MovieDeailFragment : Fragment(R.layout.fragment_movie_deail) {

    private lateinit var binding: FragmentMovieDeailBinding
    private val args by navArgs<MovieDeailFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMovieDeailBinding.bind(view)
        Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/${args.posterImageUrl}").centerCrop().into(binding.imgMovie)
        Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/${args.backgroundImageUrl}").centerCrop().into(binding.imgBackground)
        binding.txtDescription.text = args.overview
        binding.txtTitle.text = args.title
        binding.txtLenguaje.text = "Lenguaje ${args.language}"
        binding.txtRaiting.text = "${args.voteAverage} (${args.voteCount} Reviews)"
        binding.txtReleased.text = "Released ${args.releaseDate}"

    }
}