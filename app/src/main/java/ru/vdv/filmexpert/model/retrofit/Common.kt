package ru.vdv.filmexpert.model.retrofit

import ru.vdv.filmexpert.model.api.IApiTmdbService
import ru.vdv.filmexpert.model.api.TmdbApiConstants

object Common {
    val retrofitService: IApiTmdbService
        get() {
            return RetrofitClientDA.getClient(TmdbApiConstants.BASE_URL_TMDB)
                .create(IApiTmdbService::class.java)
        }
}