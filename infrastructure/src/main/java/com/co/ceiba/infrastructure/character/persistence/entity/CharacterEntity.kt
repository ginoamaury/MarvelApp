package com.co.ceiba.infrastructure.character.persistence.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.co.ceiba.domain.anotations.NoArg
import com.co.ceiba.domain.models.Character


@Entity
@NoArg
data class CharacterEntity(
   val description: String,
   @PrimaryKey val id: Int,
   val modified: String,
   val name: String,
   val resourceURI: String,
   @Embedded val thumbnail: ThumbnailEntity,
){
   constructor(character: Character): this(
      description = character.description,
      id = character.id,
      modified = character.modified,
      name = character.name,
      resourceURI = character.resourceURI,
      thumbnail = ThumbnailEntity(character.thumbnail),
   )

}