package com.shid.animelistcleanarchitecture.presentation.more


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse
import com.shid.animelistcleanarchitecture.framework.repository_implementation.IAnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoreViewModel
@Inject constructor(private val repository: IAnimeRepository) : ViewModel() {

    private var _animeAiring = MutableLiveData<List<AnimeListResponse>>()
    val animeAiring: LiveData<List<AnimeListResponse>>
        get() = _animeAiring

    fun setType(type: String) {
        viewModelScope.launch {
            try {
                val resultAiring = repository.getTopAnime(type)
                _animeAiring.value = resultAiring
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }


}