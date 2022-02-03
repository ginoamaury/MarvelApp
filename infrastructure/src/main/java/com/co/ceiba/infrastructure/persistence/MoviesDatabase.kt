package com.co.ceiba.infrastructure.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.co.ceiba.infrastructure.character.persistence.dao.CharacterDao
import com.co.ceiba.infrastructure.character.persistence.entity.CharacterEntity

@Database(entities = [CharacterEntity::class],version = 1, exportSchema = false)
abstract class MarvelDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}