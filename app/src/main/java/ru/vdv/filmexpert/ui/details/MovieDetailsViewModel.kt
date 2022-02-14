package ru.vdv.filmexpert.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.vdv.filmexpert.domain.Actor
import ru.vdv.filmexpert.domain.CallBack
import ru.vdv.filmexpert.domain.CreditsResponseTmdb
import ru.vdv.filmexpert.domain.MovieDetailTmdb
import ru.vdv.filmexpert.ui.common.BaseViewModel

class MovieDetailsViewModel : BaseViewModel() {
    private var _creditsList = MutableLiveData<List<Actor>>().apply { value = listOf() }
    val creditsList: LiveData<List<Actor>> = _creditsList
    private var _detailInfo = MutableLiveData<MovieDetailTmdb>().apply { value = null }
    val detailInfo: LiveData<MovieDetailTmdb> = _detailInfo

    fun fetchCreditsList(tmdbApiKeyV3: String, movieId: String) {
        repository.getCreditsList(tmdbApiKeyV3, movieId, object : CallBack<CreditsResponseTmdb> {
            override fun onResult(value: CreditsResponseTmdb) {
                _creditsList.value = value.cast
            }
        })
    }

    fun fetchDetailInfo(tmdbApiKeyV3: String, movieId: String) {
        repository.getDetailInfo(tmdbApiKeyV3, movieId, object : CallBack<MovieDetailTmdb> {
            override fun onResult(value: MovieDetailTmdb) {
                _detailInfo.value = value
            }
        })
    }
}