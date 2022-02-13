package ru.vdv.filmexpert.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.vdv.filmexpert.domain.Actor
import ru.vdv.filmexpert.domain.CallBack
import ru.vdv.filmexpert.domain.CreditsResponseTmdb
import ru.vdv.filmexpert.ui.common.BaseViewModel

class MovieDetailsViewModel : BaseViewModel() {
    private var _creditsList = MutableLiveData<List<Actor>>().apply { value = listOf() }
    val creditsList: LiveData<List<Actor>> = _creditsList

    fun fetchCreditsList(tmdbApiKeyV3: String, movieId: String){
        repository.getCreditsList(tmdbApiKeyV3, movieId, object : CallBack<CreditsResponseTmdb>{
            override fun onResult(value: CreditsResponseTmdb) {
                Log.d(TAG, "Данные полилучил, записал")
                _creditsList.value = value.cast
            }
        })

    }

}