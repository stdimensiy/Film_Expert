package ru.vdv.filmexpert.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.vdv.filmexpert.domain.CallBack
import ru.vdv.filmexpert.domain.MovieTmdb
import ru.vdv.filmexpert.domain.MoviesResponseTmdb
import ru.vdv.filmexpert.ui.common.BaseViewModel

class MainViewModel : BaseViewModel() {
    private var adultAdded = true
    private var _currentResponseTmdb: MoviesResponseTmdb? = null
    private var _currentPage: Int = 1
    private var prepareListMovie: ArrayList<MovieTmdb> = arrayListOf()
    private val _moviesList = MutableLiveData<ArrayList<MovieTmdb>>().apply {
        value = prepareListMovie
    }
    val moviesList: LiveData<ArrayList<MovieTmdb>> = _moviesList

    fun fetchListMovies(standardList: String, tmdbApiKeyV3: String) {
        if (_currentPage != 0) {
            repository.getStandardList(standardList, tmdbApiKeyV3, adultAdded, _currentPage,
                object : CallBack<MoviesResponseTmdb> {
                    override fun onResult(value: MoviesResponseTmdb) {
                        _currentResponseTmdb = value
                        if (value.page == _currentPage) {
                            prepareListMovie.addAll(value.results)
                            _moviesList.postValue(prepareListMovie)
                            _currentPage += if (value.totalPages > _currentPage) 1
                            else 0
                        }
                    }
                })
        }
    }
}