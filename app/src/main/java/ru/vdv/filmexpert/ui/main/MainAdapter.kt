package ru.vdv.filmexpert.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.vdv.filmexpert.domain.MovieTmdb
import ru.vdv.filmexpert.model.api.TmdbApiConstants
import ru.vdv.myapp.myreadersdiary.glide.GlideImageLoader
import ru.vdv.myapp.myreadersdiary.glide.ImageLoader

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {
    private val imageLoader: ImageLoader<ImageView> = GlideImageLoader()
    var items: List<MovieTmdb> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.title
        holder.data.text = item.releaseDate
        holder.rating.text = (item.voteAverage*10).toInt().toString()
        holder.ratingBar.setProgressCompat((item.voteAverage*10).toInt(), true)
        imageLoader.loadMovieCover(String.format(TmdbApiConstants.POSTER_URL, item.posterPath), holder.posterImage)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}