package ru.vdv.filmexpert.ui.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import ru.vdv.filmexpert.databinding.FragmentMovieDetailsBinding
import ru.vdv.filmexpert.ui.common.BaseFragment

class MovieDetailsFragment : BaseFragment<FragmentMovieDetailsBinding>() {

    private lateinit var viewModel: MovieDetailsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MovieDetailsViewModel::class.java]
    }
}