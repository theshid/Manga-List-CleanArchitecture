package com.shid.animelistcleanarchitecture.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shid.animelistcleanarchitecture.framework.database.AnimeDatabase
import com.shid.animelistcleanarchitecture.framework.database.entities.BookmarkAnime
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.CharactersListResponse
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.DetailAnimeResponse
import com.shid.animelistcleanarchitecture.framework.network.responses.detail.Promo
import com.shid.animelistcleanarchitecture.core.repository.DetailAnimeRepository
import com.shid.animelistcleanarchitecture.core.use_cases.SaveFavorite
import com.shid.animelistcleanarchitecture.core.use_cases.UnsetFavorite
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: DetailAnimeRepository,
    private val database: AnimeDatabase,
    private val saveFavorite: SaveFavorite,
    private val unsetFavorite: UnsetFavorite
) : ViewModel() {
    private var _anime = MutableLiveData<DetailAnimeResponse>()
    val anime: LiveData<DetailAnimeResponse>
        get() = _anime

    private var _isAnimeInDb = MutableLiveData<Int>()
    val isAnimeInDb: LiveData<Int>
        get() = _isAnimeInDb

    private var _characters = MutableLiveData<List<CharactersListResponse>>()
    val characters: LiveData<List<CharactersListResponse>>
        get() = _characters

    private var _videos = MutableLiveData<List<Promo>>()
    val videos: LiveData<List<Promo>>
        get() = _videos

    fun setDetailAnime(id: Int) {
        viewModelScope.launch {
            val detailAnime = repository.getDetailAnime(id)
            _anime.value = detailAnime

            val characters = repository.getCharacters(id)
            _characters.value = characters

            val videos = repository.getVideos(id)
            _videos.value = videos
        }
    }

    fun checkIfAnimeIsFavorite(animeId: Int) {

        viewModelScope.launch(Dispatchers.IO) {
            val checkAnime = database.animeDao().exists(animeId)
            Timber.d("value of anime check:$checkAnime")

            _isAnimeInDb.postValue(database.animeDao().exists(animeId))


            Timber.d("value of anime:${isAnimeInDb.value}")
        }


    }

    fun setFavorite(anime: DetailAnimeResponse) {
        viewModelScope.launch(Dispatchers.IO) {
            saveFavorite.invoke(anime)
        }

    }

    fun unSetFavorite(anime: DetailAnimeResponse) {
        viewModelScope.launch(Dispatchers.IO) {
            unsetFavorite.invoke(anime)
        }

    }
}