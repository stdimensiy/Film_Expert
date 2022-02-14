package ru.vdv.filmexpert.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Класс ProductionCompany (создан для работы с API TMDB)
 * отвечает за хранение информации о жанре
 * @param id уникальный идентификатор выпускающей компании
 * @param logo_path ссылка на логотип компании
 * @param name наименование компании
 * @param originCountry страна компании
 * @constructor создает объект, содержащий кинформацию о жанре (локализованную)
 */

@Parcelize
data class ProductionCompany(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("logo_path")
    val logo_path: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("origin_country")
    val originCountry: String
) : Parcelable
