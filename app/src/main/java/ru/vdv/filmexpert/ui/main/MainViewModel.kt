package ru.vdv.filmexpert.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.vdv.filmexpert.domain.CallBack
import ru.vdv.filmexpert.domain.MovieTmdb
import ru.vdv.filmexpert.domain.MoviesResponseTmdb
import ru.vdv.filmexpert.ui.common.BaseViewModel

class MainViewModel: BaseViewModel() {
    private var tmdbApiKeyV3: String = ""
    private var adultAdded = true
    private val _moviesList = MutableLiveData<List<MovieTmdb>>().apply {
        value = null
    }
    val moviesList: LiveData<List<MovieTmdb>> = _moviesList

    fun fetchListMovies(standardList: String, page: Int){
        repository.getStandartList(standardList, tmdbApiKeyV3, adultAdded, page, object :
            CallBack<MoviesResponseTmdb> {
            override fun onResult(value: MoviesResponseTmdb) {
                _moviesList.value = value.results
            }
        })
    }
}