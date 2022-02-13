package ru.vdv.filmexpert.model.repository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.vdv.filmexpert.domain.CallBack
import ru.vdv.filmexpert.domain.CreditsResponseTmdb
import ru.vdv.filmexpert.domain.MoviesResponseTmdb
import ru.vdv.filmexpert.model.api.IApiTmdbService
import ru.vdv.filmexpert.model.api.TmdbApiConstants
import ru.vdv.filmexpert.model.retrofit.Common


class Repository : IRepository {
    private val networkServiceTmdb: IApiTmdbService = Common.retrofitService
    override fun getStandardList(
        standardList: String,
        tmdbApiKeyV3: String,
        adultAdded: Boolean,
        page: Int,
        callBack: CallBack<MoviesResponseTmdb>
    ) {
        networkServiceTmdb.sectionMoviesGetStandardsLists(
            TmdbApiConstants.DEFAULT_API_VERSION,
            standardList,
            tmdbApiKeyV3,
            page,
            TmdbApiConstants.LANGUAGE_ANSWER,
            adultAdded
        )
            .enqueue(object : Callback<MoviesResponseTmdb> {
                override fun onResponse(
                    call: Call<MoviesResponseTmdb>,
                    response: Response<MoviesResponseTmdb>
                ) {
                    response.body()?.let { callBack.onResult(it) }
                }

                override fun onFailure(call: Call<MoviesResponseTmdb>, t: Throwable) {
                }
            })
    }

    override fun getCreditsList(
        tmdbApiKeyV3: String,
        movieId: String,
        callBack: CallBack<CreditsResponseTmdb>
    ){
        networkServiceTmdb.sectionMoviesGetCredits(
            TmdbApiConstants.DEFAULT_API_VERSION,
            movieId,
            tmdbApiKeyV3,
            TmdbApiConstants.LANGUAGE_ANSWER
        )
            .enqueue(object : Callback<CreditsResponseTmdb> {
                override fun onResponse(
                    call: Call<CreditsResponseTmdb>,
                    response: Response<CreditsResponseTmdb>
                ) {
                    response.body()?.let {
                        callBack.onResult(it)
                    }
                }

                override fun onFailure(call: Call<CreditsResponseTmdb>, t: Throwable) {
                }
            })
    }
}