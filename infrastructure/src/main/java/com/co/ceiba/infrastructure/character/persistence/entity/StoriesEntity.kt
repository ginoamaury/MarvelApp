package com.co.ceiba.infrastructure.character.persistence.entity

import androidx.room.Embedded
import com.co.ceiba.domain.anotations.NoArg
import com.co.ceiba.domain.models.Stories

@NoArg
class StoriesEntity(
   val availableStories: Int,
   val collectionURIStories: String,
   @Embedded val itemsStories: List<StoryEntity>,
   val returnedStories: Int
){
   constructor(stories: Stories): this(
      availableStories = stories.available,
      collectionURIStories = stories.collectionURI,
      itemsStories = stories.items.map { StoryEntity(it) },
      returnedStories = stories.returned
   )
}