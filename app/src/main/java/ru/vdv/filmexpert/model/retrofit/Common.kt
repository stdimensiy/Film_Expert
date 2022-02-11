package ru.vdv.myapp.myreadersdiary.model.retrofit

import ru.vdv.filmexpert.model.api.IApiTmdbService

object Common {
    private const val BASE_URL_TMDB = "https://api.themoviedb.org/"

    val retrofitService: IApiTmdbService
        get() {
            return RetrofitClientDA.getClient(BASE_URL_TMDB)
                .create(IApiTmdbService::class.java)
        }
}