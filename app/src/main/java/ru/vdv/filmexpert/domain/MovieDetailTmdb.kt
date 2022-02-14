package ru.vdv.filmexpert.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Класс MovieDetailTmdb (создан для работы с API TMDB)
 * отвечает за хранение более детальной информации о фильме
 * @param adult ............. - признак принадлежности фильма к категории "Для взрослых"
 * @param backdropPath ...... - ссылка на штатное изображение фона для данного фильма
 * @param genres ............ - список жанров (в виде объектов Genre)
 * @param id ................ - уникальный идентификатор фильма в базе
 * @param originalLanguage .. - оригинальный язык фильма (двухсимвольный стандарт, не Caps! (en)
 * @param originalTitle ..... - оригинальное наименоавние на оригинальном языке
 * @param overview .......... - краткое описание на установленном языке ответа (если есть)
 * @param popularity ........ - популярность (double)
 * @param posterPath ........ - ссылка на штатный постер локализованный относительно языка ответа
 * @param releaseDate ....... - дата релиза (может быть разной, в зависимости от выбранного региона)
 * @param title ............. - официальное наименование на языке ответа
 * @param video ............. - признак, есть ли к данному объекту (фильму) видео (трейлер)
 * @param voteAverage ....... - средний бал популярности (0-10) по версии TMDB
 * @param voteCount ......... - количество проголосовавших пользователей
 * @constructor создает объект, содержащий краткую общую информацию о фильме (TMDB API dthcbz 3)
 */

@Parcelize
data class MovieDetailTmdb(
    @SerializedName("adult")
    val adult: Boolean = false,
    @SerializedName("backdrop_path")
    val backdropPath: String = "",
    @SerializedName("belongs_to_collection")
    val belongsToCollection: List<MovieCollection> = listOf(),
    @SerializedName("budget")
    val budget: Int = 0,
    @SerializedName("genres")
    val genres: List<Genre> = listOf(),
    @SerializedName("homepage")
    val homepage: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("imdb_id")
    val imdbId: String = "",
    @SerializedName("original_language")
    val originalLanguage: String = "",
    @SerializedName("original_title")
    val originalTitle: String = "",
    @SerializedName("overview")
    val overview: String = "",
    @SerializedName("popularity")
    val popularity: Double = 0.toDouble(),
    @SerializedName("poster_path")
    val posterPath: String = "",
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany> = listOf(),
    @SerializedName("release_date")
    val releaseDate: String = "",
    @SerializedName("revenue")
    val revenue: Int = 0,
    @SerializedName("runtime")
    val runtime: Int = 0,
    @SerializedName("tagline")
    val tagline: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("video")
    val video: Boolean = false,
    @SerializedName("vote_average")
    val voteAverage: Double = 0.toDouble(),
    @SerializedName("vote_count")
    val voteCount: Int = 0
) : Parcelable