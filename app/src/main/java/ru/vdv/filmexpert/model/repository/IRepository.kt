package ru.vdv.filmexpert.model.repository

import ru.vdv.filmexpert.domain.CallBack
import ru.vdv.filmexpert.domain.CreditsResponseTmdb
import ru.vdv.filmexpert.domain.MoviesResponseTmdb

interface IRepository {
    fun getStandardList(
        standardList: String,
        tmdbApiKeyV3: String,
        adultAdded: Boolean,
        page: Int,
        callBack: CallBack<MoviesResponseTmdb>
    )

    fun getCreditsList(
        tmdbApiKeyV3: String,
        movieId: String,
        callBack: CallBack<CreditsResponseTmdb>
    )
}