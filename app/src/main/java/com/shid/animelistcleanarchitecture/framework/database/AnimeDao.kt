package com.shid.animelistcleanarchitecture.framework.database

import androidx.room.*
import com.shid.animelistcleanarchitecture.framework.database.entities.BookmarkAnime

@Dao
interface AnimeDao {

    //Insert Bookmark Animes
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBookmarkAnimes(anime: BookmarkAnime)

    //Get all bookmark animes
    @Query("SELECT * FROM bookmark_anime")
    fun getBookmarkAnimes():List<BookmarkAnime>

    @Query("SELECT EXISTS (SELECT 1 FROM bookmark_anime WHERE anime_id IN (:id))")
    fun exists(id: Int): Int

    //Delete bookmark anime
    @Delete
    fun unBookmarkAnime(anime: BookmarkAnime)


}