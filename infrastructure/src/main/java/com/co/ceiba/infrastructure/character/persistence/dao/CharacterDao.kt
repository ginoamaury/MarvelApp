package com.co.ceiba.infrastructure.character.persistence.dao

import androidx.room.*
import com.co.ceiba.infrastructure.character.persistence.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Transaction
    @Query("SELECT * FROM CharacterEntity")
    fun getAllCharacters (): Flow<List<CharacterEntity>>

    @Transaction
    @Query("SELECT * FROM CharacterEntity WHERE name LIKE '' || :name || '%'")
    fun getCharactersByName (name: String): Flow<List<CharacterEntity>>

    @Transaction
    @Query("SELECT * FROM CharacterEntity WHERE id = :id")
    fun getCharacterById(id : Int) : Flow<CharacterEntity>

    @Transaction
    @Query("SELECT COUNT(*) FROM CharacterEntity")
    fun getCountCharacters() : Int

    @Transaction
    @Query("SELECT COUNT(id) FROM CharacterEntity WHERE id= :id")
    fun characterExist(id:Int):Int

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(movies: List<CharacterEntity>)

}