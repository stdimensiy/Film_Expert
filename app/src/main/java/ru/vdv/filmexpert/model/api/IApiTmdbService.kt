package ru.vdv.filmexpert.model.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.vdv.filmexpert.domain.CreditsResponseTmdb
import ru.vdv.filmexpert.domain.MovieDetailTmdb
import ru.vdv.filmexpert.domain.MoviesResponseTmdb

interface IApiTmdbService {
    /**
     * Раздел API: Movies
     * Режим standards lists (согласно документации есть только 4 стандартных листа now_playing, popular, top_rated и upcoming
     * @param apiVersion версия API с которой приято решение работать
     * @param key базовый ключ пользователя API key
     * @param page номер запрашиваемой страницы ( >=1 )
     * @param region регион поиска (пока отключен) код ISO 3166-1
     * @param language установка базового языка ответа
     * @param standardList указатель стандартной выборки результатов (адрес относительно /movie/)
     * @param includeAdult флаг включения в выборку фиильмов для взрослых
     * @return возвращает список фиьмов с самым высоким рейтонгом по версии TMDB.
     */
    @GET("{api_version}/movie/{standard_list}")
    fun sectionMoviesGetStandardsLists(
        @Path("api_version") apiVersion: Int,
        @Path("standard_list") standardList: String,
        @Query("api_key") key: String,
        @Query("page") page: Int,
        @Query("language") language: String,
        @Query("include_adult") includeAdult: Boolean
        //@Query("region") region: String
    ): Call<MoviesResponseTmdb>


    /**
     * Раздел API: Movies Получить список участников (актеров и съемочной группы)
     * Режим полечения дополнительной информации
     * @param apiVersion версия API с которой приято решение работать
     * @param key базовый ключ пользователя API key
     * @param language установка базового языка ответа
     * @return возвращает список актеров и участников съемочного процесса отсортированный
     * согласно рейтингу по версии TMDB.
     */
    @GET("{api_version}/movie/{movie_id}/casts")
    fun sectionMoviesGetCredits(
        @Path("api_version") apiVersion: Int,
        @Path("movie_id") movieId: String,
        @Query("api_key") key: String,
        @Query("language") language: String,
    ): Call<CreditsResponseTmdb>

    /**
     * Раздел API - Movies  Получить детализированную информацию о фильме
     * Режим полечения дополнительной информации
     * @param apiVersion версия API с которой приято решение работать
     * @param key базовый ключ пользователя API key
     * @param language установка базового языка ответа
     * @return возвращает расширенный набор полей для объекта фильма по версии TMDB.
     */
    @GET("{api_version}/movie/{movie_id}")
    fun sectionMoviesGetDetailInfo(
        @Path("api_version") apiVersion: Int,
        @Path("movie_id") movieId: String,
        @Query("api_key") key: String,
        @Query("language") language: String,
    ): Call<MovieDetailTmdb>
}