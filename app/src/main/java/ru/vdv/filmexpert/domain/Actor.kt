package ru.vdv.filmexpert.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
/**
 * Класс Actor (создан для корректного приема данных сервиса TMDB)
 * отвечает за хранение данных об актерах
 * @param adult  Признак (взрослый или ребенок)
 * @param gender Пол (ну текущее его значение)
 * @param knownForDepartment  Какому подразделению принадлежит
 * @param name  ФИО актора
 * @param originalName  Настоящее ФИО актера
 * @param popularity  Индекс популярности
 * @param profilePath  Ссылка на файл картинки профиля актера (аватара)
 * @param castId  Идентификатор актера
 * @param character  Персонаж (Объекты актера формируются в результате выборки актерского состава по
 * конкретному фильму, поэтуму данное поле содержит наименование персонажа для конкретного фильма *
 * @constructor создает объект содержащий два списка (актеры и съемочная группа фильма)
 */

@Parcelize
data class Actor(
    @SerializedName("adult")
    val adult: Boolean = false,
    @SerializedName("gender")
    val gender: Int = 0,
    @SerializedName("known_for_department")
    val knownForDepartment: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("original_name")
    val originalName: String = "",
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("profile_path")
    val profilePath: String = "",
    @SerializedName("cast_id")
    val castId: Int = 0,
    @SerializedName("character")
    val character: String = "",
    @SerializedName("credit_id")
    val creditId: String = "",
    @SerializedName("order")
    val order: Int = 0,
): Parcelable
