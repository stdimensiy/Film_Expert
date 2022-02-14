package ru.vdv.filmexpert.domain

/**
 * Класс CreditsResponseTmdb (создан для корректного приема данных сервиса TMDB)
 * отвечает за хранение результатов выборки персон включенных в состав рабочей группы фильма
 * @param id  Идентификатор фильма для которого предоставляется выборка
 * @param cast Список актеров
 * @param crew  Список рабочей группы фильма
 * @constructor создает объект содержащий два списка (актеры и рабочая группа фильма)
 */
data class CreditsResponseTmdb(
    val id: Int = 0,
    val cast: List<Actor> = listOf(),
    val crew: List<Actor> = listOf(),
)
