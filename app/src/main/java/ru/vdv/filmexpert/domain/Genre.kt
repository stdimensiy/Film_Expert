package ru.vdv.filmexpert.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Класс Genre (создан для работы с API TMDB)
 * отвечает за хранение информации о жанре
 * @param id уникальный идентификатор жанра в баде
 * @param name наименование жанра (согласно согласно локализации)
 * @constructor создает объект, содержащий кинформацию о жанре (локализованную)
 */

@Parcelize
data class Genre(
    val id: Int = 0,
    val name: String = ""
) : Parcelable
