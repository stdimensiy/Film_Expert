package ru.vdv.filmexpert.domain

import com.google.gson.annotations.SerializedName

/**
 * Класс ListMovies (создан для конфигурирования содержимого фрагментов)
 * отвечает за хранение результатов выборки для каждой конктерной группы
 * @param page ............ - Номер очередной страницы ответа
 * @param results ......... - Список объектов(фильмов) ответа (TMDB выдает их партиями по 20 шт.)
 * @param totalPages ...... - Всего возможных страниц ответа
 * @param totalResults .... - Общее количество возможных объектов(фильмов) ответа (одномоментно)
 * @constructor создает объект содержащий очередной ответ сервера (часть выборки)
 */
data class CreditsResponseTmdb(
    val id: Int = 0,
    val cast: List<Actor> = listOf(),
    val crew: List<Actor> = listOf(),
)
