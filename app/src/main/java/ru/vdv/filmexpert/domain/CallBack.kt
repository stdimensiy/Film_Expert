package ru.vdv.filmexpert.domain

interface CallBack<T> {
    fun onResult(value: T)
}