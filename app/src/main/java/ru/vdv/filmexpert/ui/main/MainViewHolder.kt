package ru.vdv.filmexpert.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.vdv.filmexpert.databinding.ItemListMovieRoundBinding
import ru.vdv.filmexpert.databinding.ItemListMoviesBinding

class MainViewHolder(
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemListMovieRoundBinding = ItemListMovieRoundBinding.inflate(li, parent, false)
) : RecyclerView.ViewHolder(binding.root) {
    val name = binding.tvNameMovie
    val data = binding.tvDate
    val rating = binding.tvRating
    val ratingBar = binding.progressBar
    val posterImage = binding.ivPosterListItem
}