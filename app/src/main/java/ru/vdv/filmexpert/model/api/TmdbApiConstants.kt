package ru.vdv.filmexpert.model.api

object TmdbApiConstants {

    /** Рабочая (основная по умолчанию) версия API */
    const val DEFAULT_API_VERSION = 3

    /** Server endpoint  фдрес базового размещеия графического материала  */
    private const val IMAGE_SERVER_URL = "https://image.tmdb.org/t/p/"

    /** Poster size - разрешение постера - пока так, в дальнейшем в перечисление  */
    private const val POSTER_SIZE = "w500"

    /** language answer - язык ответа  */
    const val LANGUAGE_ANSWER = "ru-RU"

    /** форматная строка сборного адреса картинки  */
    const val POSTER_URL = "$IMAGE_SERVER_URL$POSTER_SIZE%1\$s"
}