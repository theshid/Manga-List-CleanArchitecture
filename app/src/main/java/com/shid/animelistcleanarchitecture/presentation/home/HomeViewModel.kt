package com.shid.animelistcleanarchitecture.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse
import com.shid.animelistcleanarchitecture.core.use_cases.GetTopAnimes
import com.shid.animelistcleanarchitecture.core.use_cases.LoadDayNightStatus
import com.shid.animelistcleanarchitecture.core.use_cases.SetNightMode
import com.shid.animelistcleanarchitecture.utils.SavePref
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val getTopAnimes: GetTopAnimes,
    private val setNightMode: SetNightMode,
    private val loadDayNightStatus: LoadDayNightStatus
) : ViewModel() {

    private var _animeAiring = MutableLiveData<List<AnimeListResponse>>()
    val animeAiring: LiveData<List<AnimeListResponse>>
        get() = _animeAiring

    private var _animeUpcoming = MutableLiveData<List<AnimeListResponse>>()
    val animeUpcoming: LiveData<List<AnimeListResponse>>
        get() = _animeUpcoming

    private var _animeTV = MutableLiveData<List<AnimeListResponse>>()
    val animeTV: LiveData<List<AnimeListResponse>>
        get() = _animeTV

    private var _animeMovie = MutableLiveData<List<AnimeListResponse>>()
    val animeMovie: LiveData<List<AnimeListResponse>>
        get() = _animeMovie

    private var _animeOva = MutableLiveData<List<AnimeListResponse>>()
    val animeOva: LiveData<List<AnimeListResponse>>
        get() = _animeOva

    init {
        viewModelScope.launch {
            try {
                val resultAiring = getTopAnimes.getTopAnimes("airing")
                _animeAiring.value = resultAiring

                val resultUpcoming = getTopAnimes.getTopAnimes("upcoming")
                _animeUpcoming.value = resultUpcoming

                val resultTV = getTopAnimes.getTopAnimes("tv")
                _animeTV.value = resultTV

                val resultMovie = getTopAnimes.getTopAnimes("movie")
                _animeMovie.value = resultMovie

                val resultOva = getTopAnimes.getTopAnimes("ova")
                _animeOva.value = resultOva
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    fun setDayNight(status: Boolean) {
        setNightMode.setDayNight(status)
    }

    fun loadDayNight(): Boolean {
        return loadDayNightStatus.loadDayNight()
    }
}