package com.shid.animelistcleanarchitecture.core.use_cases

import com.shid.animelistcleanarchitecture.utils.SavePref
import javax.inject.Inject

class SetNightMode @Inject constructor(private val savePref: SavePref) {
    fun setDayNight(status: Boolean) {
        savePref.setNightMode(state = status)
    }
}