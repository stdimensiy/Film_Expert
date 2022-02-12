package ru.vdv.filmexpert.ui.main

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.vdv.filmexpert.R
import ru.vdv.filmexpert.domain.MovieTmdb
import ru.vdv.filmexpert.model.api.TmdbApiConstants
import ru.vdv.myapp.myreadersdiary.glide.GlideImageLoader
import ru.vdv.myapp.myreadersdiary.glide.ImageLoader

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    private val imageLoader: ImageLoader<ImageView> = GlideImageLoader()
    var items: List<MovieTmdb> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context), parent)
    }

    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = items[position]
        val roundedRatingValue = (item.voteAverage * 10).toInt()
        holder.name.text = item.title
        holder.data.text = item.releaseDate
        val viewContext = holder.itemView.context
        val rBar = holder.ratingBar
        holder.rating.text = roundedRatingValue.toString()
        rBar.setProgressCompat(roundedRatingValue, true)

        when (roundedRatingValue) {
            in 0..5 -> {
                rBar.setIndicatorColor(Color.RED)
                rBar.setProgressCompat(5, true)
            }
            in 6..10 -> rBar.setIndicatorColor(Color.parseColor(viewContext.getString(R.color.red_to_green_010)))
            in 11..15 -> rBar.setIndicatorColor(Color.parseColor(viewContext.getString(R.color.red_to_green_015)))
            in 16..20 -> rBar.setIndicatorColor(Color.parseColor(viewContext.getString(R.color.red_to_green_020)))
            in 21..25 -> rBar.setIndicatorColor(Color.parseColor(viewContext.getString(R.color.red_to_green_025)))
            in 26..30 -> rBar.setIndicatorColor(Color.parseColor(viewContext.getString(R.color.red_to_green_030)))
            in 31..35 -> rBar.setIndicatorColor(Color.parseColor(viewContext.getString(R.color.red_to_green_035)))
            in 40..60 -> rBar.setIndicatorColor(Color.YELLOW)
            in 61..65 -> rBar.setIndicatorColor(Color.parseColor(viewContext.getString(R.color.red_to_green_040)))
            in 66..70 -> rBar.setIndicatorColor(Color.parseColor(viewContext.getString(R.color.red_to_green_045)))
            in 71..75 -> rBar.setIndicatorColor(Color.parseColor(viewContext.getString(R.color.red_to_green_050)))
            in 76..80 -> rBar.setIndicatorColor(Color.parseColor(viewContext.getString(R.color.red_to_green_060)))
            in 81..85 -> rBar.setIndicatorColor(Color.parseColor(viewContext.getString(R.color.red_to_green_070)))
            in 86..90 -> rBar.setIndicatorColor(Color.parseColor(viewContext.getString(R.color.red_to_green_080)))
            in 91..95 -> rBar.setIndicatorColor(Color.parseColor(viewContext.getString(R.color.red_to_green_090)))
            in 96..10000 -> rBar.setIndicatorColor(Color.GREEN)
        }
            imageLoader.loadMovieCover(
            String.format(TmdbApiConstants.POSTER_URL, item.posterPath),
            holder.posterImage
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }
}