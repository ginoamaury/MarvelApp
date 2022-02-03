package com.co.ceiba.infrastructure.character.repositories

import android.content.SharedPreferences
import com.co.ceiba.domain.repositories.CharacterTemporalRepository
import com.co.ceiba.infrastructure.dependencyInjection.LAST_UPDATED


class CharacterSharedPreferencesRepository(private val sharedPreferences: SharedPreferences) :
    CharacterTemporalRepository {

    override fun getLastUpdatedPreference(): String =
        sharedPreferences.getString(LAST_UPDATED, "").toString()

    override fun saveLastUpdatedPreference(lastUpdated: String) {
        sharedPreferences.edit().putString(LAST_UPDATED, lastUpdated).apply()
    }

}