package ru.vdv.filmexpert.model.repository

import ru.vdv.filmexpert.domain.CallBack
import ru.vdv.filmexpert.domain.MoviesResponseTmdb

interface IRepository {
    fun getStandartList(
        standardList: String,
        tmdbApiKeyV3: String,
        adultAdded: Boolean,
        page: Int,
        callBack: CallBack<MoviesResponseTmdb>
    )
}