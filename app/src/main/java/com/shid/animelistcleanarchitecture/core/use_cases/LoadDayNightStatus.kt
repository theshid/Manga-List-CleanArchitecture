package com.shid.animelistcleanarchitecture.core.use_cases

import com.shid.animelistcleanarchitecture.utils.SavePref
import javax.inject.Inject

class LoadDayNightStatus @Inject constructor(private val savePref: SavePref) {

    fun loadDayNight():Boolean{
        return savePref.loadNightMode()
    }
}