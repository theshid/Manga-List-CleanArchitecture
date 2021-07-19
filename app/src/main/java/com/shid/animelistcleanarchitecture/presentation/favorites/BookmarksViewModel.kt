package com.shid.animelistcleanarchitecture.presentation.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shid.animelistcleanarchitecture.core.use_cases.GetBookmarks
import com.shid.animelistcleanarchitecture.framework.database.AnimeDatabase
import com.shid.animelistcleanarchitecture.framework.database.entities.BookmarkAnime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BookmarksViewModel @Inject constructor(private val getBookmark: GetBookmarks) : ViewModel() {
    private var _list = MutableLiveData<List<BookmarkAnime>>()
    val bookmarkList: LiveData<List<BookmarkAnime>>
        get() = _list

    fun getAllBookmarks(){
        viewModelScope.launch(Dispatchers.IO){
            val animeList = getBookmark.getBookmarks()
            _list.postValue(animeList)
        }
    }
}