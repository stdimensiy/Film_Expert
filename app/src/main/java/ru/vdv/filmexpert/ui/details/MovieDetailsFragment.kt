package ru.vdv.filmexpert.ui.details

import android.content.pm.PackageManager
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ru.vdv.filmexpert.databinding.FragmentMovieDetailsBinding
import ru.vdv.filmexpert.domain.MovieTmdb
import ru.vdv.filmexpert.ui.common.BaseConstants
import ru.vdv.filmexpert.ui.common.BaseFragment

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movie = arguments?.getParcelable(BaseConstants.MY_MOVIE_BUNDLE_KEY)!!
        viewModel = ViewModelProvider(this)[MovieDetailsViewModel::class.java]
        if (savedInstanceState == null) viewModel.fetchCreditsList(apikey,"181812")
        //imageLoader.loadMovieCover(movie.posterPath, binding.ivPoster)
        val actorList = binding.rvActorList
        actorList.adapter = adapter
        actorList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        viewModel.creditsList.observe(viewLifecycleOwner) {
            adapter.items = it
            Log.d(TAG, "Новые данные в адаптер передал: $it")
            adapter.notifyDataSetChanged()
        }


    }
}