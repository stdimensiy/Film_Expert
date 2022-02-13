package ru.vdv.filmexpert.ui.details

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Parcel
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import ru.vdv.filmexpert.R
import ru.vdv.filmexpert.databinding.FragmentMovieDetailsBinding
import ru.vdv.filmexpert.domain.MovieTmdb
import ru.vdv.filmexpert.model.api.TmdbApiConstants
import ru.vdv.filmexpert.ui.common.BaseConstants
import ru.vdv.filmexpert.ui.common.BaseFragment
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

class MovieDetailsFragment : BaseFragment<FragmentMovieDetailsBinding>() {

    private lateinit var viewModel: MovieDetailsViewModel
    private lateinit var adapter: ActorsListAdapter
    private lateinit var movie: MovieTmdb
    private var apikey: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = ActorsListAdapter()
        apikey = requireContext().applicationContext.packageManager.getApplicationInfo(
            requireContext().applicationContext.packageName,
            PackageManager.GET_META_DATA
        ).metaData["keyValue"].toString()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    @SuppressLint("ResourceType")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            it.getParcelable<MovieTmdb>(BaseConstants.MY_MOVIE_BUNDLE_KEY)?.let { movie = it }
        }
        viewModel = ViewModelProvider(this)[MovieDetailsViewModel::class.java]
        if (savedInstanceState == null) viewModel.fetchCreditsList(apikey, movie.id.toString())

        //Заполняем данными поля фрагмента
        imageLoader.loadMovieCover(
            String.format(TmdbApiConstants.POSTER_URL, movie.posterPath),
            binding.ivPoster
        )

        val roundedRatingValue = (movie.voteAverage * 10).toInt()
        val cdata = LocalDate.parse(movie.releaseDate)
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
        binding.tvReleasedBody.text = prepareStringData
        val rBar = binding.progressBar
        binding.tvRating.text = roundedRatingValue.toString()
        rBar.setProgressCompat(roundedRatingValue, true)

        var er = 0
        when (roundedRatingValue) {
            in 0..5 -> {
                er = Color.RED
                rBar.setProgressCompat(5, true)
            }
            in 6..10 -> er = Color.parseColor(context?.getString(R.color.red_to_green_010))
            in 11..15 -> er = Color.parseColor(context?.getString(R.color.red_to_green_015))
            in 16..20 -> er = Color.parseColor(context?.getString(R.color.red_to_green_020))
            in 21..25 -> er = Color.parseColor(context?.getString(R.color.red_to_green_025))
            in 26..30 -> er = Color.parseColor(context?.getString(R.color.red_to_green_030))
            in 31..35 -> er = Color.parseColor(context?.getString(R.color.red_to_green_035))
            in 40..60 -> er = Color.YELLOW
            in 61..65 -> er = Color.parseColor(context?.getString(R.color.red_to_green_040))
            in 66..70 -> er = Color.parseColor(context?.getString(R.color.red_to_green_045))
            in 71..75 -> er = Color.parseColor(context?.getString(R.color.red_to_green_050))
            in 76..80 -> er = Color.parseColor(context?.getString(R.color.red_to_green_060))
            in 81..85 -> er = Color.parseColor(context?.getString(R.color.red_to_green_070))
            in 86..90 -> er = Color.parseColor(context?.getString(R.color.red_to_green_080))
            in 91..95 -> er = Color.parseColor(context?.getString(R.color.red_to_green_090))
            in 96..10000 -> er = Color.GREEN
        }
        rBar.setIndicatorColor(er)
        binding.tvOverviewBody.text = movie.overview



        imageLoader.loadMovieBackground(
            String.format(TmdbApiConstants.POSTER_URL, movie.backdropPath),
            binding.ivBgMovie
        )
        binding.tvNameMovie.text = movie.title
        val actorList = binding.rvActorList
        actorList.adapter = adapter
        actorList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewModel.creditsList.observe(viewLifecycleOwner) {
            adapter.items = it
            adapter.notifyDataSetChanged()
        }


    }
}