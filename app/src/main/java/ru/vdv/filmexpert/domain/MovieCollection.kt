package ru.vdv.filmexpert.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Класс MovieCollection (создан для корректного приема данных сервиса TMDB)
 * отвечает за хранение информации о коллекции (к которой принадлежит фильм выборки)
 * @param id  Идентификатор коллекции
 * @param name Наименование коллекции (возвращается локализованным)
 * @param posterPath  ссылка на постер коллекции
 * @param backdropPath  ссылка на фон 9второй постер) коллекции
 * @constructor создает объект содержащий информацию о коллекции в котороую включен фильм
 */
@Parcelize
data class MovieCollection(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("poster_path")
    val posterPath: String = "",
    @SerializedName("backdrop_path")
    val backdropPath: String = ""
): Parcelable
