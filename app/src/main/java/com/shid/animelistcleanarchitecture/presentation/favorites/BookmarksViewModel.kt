package com.shid.animelistcleanarchitecture.presentation.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shid.animelistcleanarchitecture.framework.database.AnimeDatabase
import com.shid.animelistcleanarchitecture.framework.database.entities.BookmarkAnime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BookmarksViewModel @Inject constructor(private val database: AnimeDatabase) : ViewModel() {
    private var _list = MutableLiveData<List<BookmarkAnime>>()
    val bookmarkList: LiveData<List<BookmarkAnime>>
        get() = _list

    fun getAllBookmarks(){
        viewModelScope.launch(Dispatchers.IO){
            val animeList = database.animeDao().getBookmarkAnimes()
            _list.postValue(animeList)
        }
    }
}