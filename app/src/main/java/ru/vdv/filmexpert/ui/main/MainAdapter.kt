package ru.vdv.filmexpert.ui.main

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.provider.BaseColumns
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.vdv.filmexpert.R
import ru.vdv.filmexpert.domain.MovieTmdb
import ru.vdv.filmexpert.model.api.TmdbApiConstants
import ru.vdv.filmexpert.ui.common.BaseConstants
import ru.vdv.myapp.myreadersdiary.glide.GlideImageLoader
import ru.vdv.myapp.myreadersdiary.glide.ImageLoader
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    private val imageLoader: ImageLoader<ImageView> = GlideImageLoader()
    var items: List<MovieTmdb> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context), parent)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ResourceType")
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = items[position]
        val roundedRatingValue = (item.voteAverage * 10).toInt()
        holder.name.text = item.title
        val cdata = LocalDate.parse(item.releaseDate)
        // DateTimeFormatter не получается нормально выдать формат месяца, не устраивает шаблон
        // решение вопроса вручную, метод .capitalize теперь Deprecated , так что и его действие
        // нужно будет на этапе зачистки кода реализовано вручную.
        val prepareStringData = String.format(
            "%02d %s %s",
            cdata.dayOfMonth,
            (cdata.month.getDisplayName(
                TextStyle.SHORT,
                Locale.forLanguageTag("RU")
            )).capitalize(Locale.forLanguageTag("RU")).substring(0, 3),
            cdata.year
        )
        holder.data.text = prepareStringData
        val viewContext = holder.itemView.context
        val rBar = holder.ratingBar
        holder.rating.text = roundedRatingValue.toString()
        rBar.setProgressCompat(roundedRatingValue, true)

        var er = 0
        when (roundedRatingValue) {
            in 0..5 -> {
                er = Color.RED
                rBar.setProgressCompat(5, true)
            }
            in 6..10 -> er = Color.parseColor(viewContext.getString(R.color.red_to_green_010))
            in 11..15 -> er = Color.parseColor(viewContext.getString(R.color.red_to_green_015))
            in 16..20 -> er = Color.parseColor(viewContext.getString(R.color.red_to_green_020))
            in 21..25 -> er = Color.parseColor(viewContext.getString(R.color.red_to_green_025))
            in 26..30 -> er = Color.parseColor(viewContext.getString(R.color.red_to_green_030))
            in 31..35 -> er = Color.parseColor(viewContext.getString(R.color.red_to_green_035))
            in 40..60 -> er = Color.YELLOW
            in 61..65 -> er = Color.parseColor(viewContext.getString(R.color.red_to_green_040))
            in 66..70 -> er = Color.parseColor(viewContext.getString(R.color.red_to_green_045))
            in 71..75 -> er = Color.parseColor(viewContext.getString(R.color.red_to_green_050))
            in 76..80 -> er = Color.parseColor(viewContext.getString(R.color.red_to_green_060))
            in 81..85 -> er = Color.parseColor(viewContext.getString(R.color.red_to_green_070))
            in 86..90 -> er = Color.parseColor(viewContext.getString(R.color.red_to_green_080))
            in 91..95 -> er = Color.parseColor(viewContext.getString(R.color.red_to_green_090))
            in 96..10000 -> er = Color.GREEN
        }
        rBar.setIndicatorColor(er)

        imageLoader.loadMovieCover(
            String.format(TmdbApiConstants.POSTER_URL, item.posterPath),
            holder.posterImage
        )
    }

    override fun onViewAttachedToWindow(holder: MainViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            val bundle = Bundle()
            bundle.putParcelable(BaseConstants.MY_MOVIE_BUNDLE_KEY, items[holder.adapterPosition])
            holder.itemView.findNavController().navigate(R.id.blankFragment)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}