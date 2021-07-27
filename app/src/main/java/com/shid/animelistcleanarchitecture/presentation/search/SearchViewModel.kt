package com.shid.animelistcleanarchitecture.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shid.animelistcleanarchitecture.framework.network.responses.main_response.AnimeListResponse
import com.shid.animelistcleanarchitecture.core.use_cases.GetSearchAnimes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSearchAnimes: GetSearchAnimes
) :
    ViewModel() {

    private var _animeResult = MutableLiveData<List<AnimeListResponse>>()
    val animeResult: LiveData<List<AnimeListResponse>>
        get() = _animeResult


    fun setResult(query: String) {
        viewModelScope.launch {
            try {
                val result = getSearchAnimes.getSearchAnimes(query)
                _animeResult.value = result
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}