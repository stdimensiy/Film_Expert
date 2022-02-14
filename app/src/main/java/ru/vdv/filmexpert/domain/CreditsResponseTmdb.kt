package ru.vdv.filmexpert.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Класс CreditsResponseTmdb (создан для корректного приема данных сервиса TMDB)
 * отвечает за хранение результатов выборки персон включенных в состав рабочей группы фильма
 * @param id  Идентификатор фильма для которого предоставляется выборка
 * @param cast Список актеров
 * @param crew  Список съемочной группы фильма
 * @constructor создает объект содержащий два списка (актеры и съемочная группа фильма)
 */
@Parcelize
data class CreditsResponseTmdb(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("cast")
    val cast: List<Actor> = listOf(),
    @SerializedName("crew")
    val crew: List<Actor> = listOf(),
): Parcelable
