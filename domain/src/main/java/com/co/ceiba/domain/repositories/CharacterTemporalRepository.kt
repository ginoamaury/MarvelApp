package com.co.ceiba.domain.repositories

interface CharacterTemporalRepository {
    fun getLastUpdatedPreference (): String
    fun saveLastUpdatedPreference (lastUpdated: String)
}