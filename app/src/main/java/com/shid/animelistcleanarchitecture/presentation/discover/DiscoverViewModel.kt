package com.shid.animelistcleanarchitecture.presentation.discover

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse
import com.shid.animelistcleanarchitecture.core.repository.IAnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DiscoverViewModel @Inject constructor( private val repository: IAnimeRepository) : ViewModel() {

    private var _animeSeason = MutableLiveData<List<AnimeListResponse>>()
    val animeSeason: LiveData<List<AnimeListResponse>>
        get() = _animeSeason

    fun setSeason(year: Int, season: String) {
        viewModelScope.launch {
            try {
                val resultAiring = repository.getSeasonAnime(year, season)
                _animeSeason.value = resultAiring
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}