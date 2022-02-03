package com.co.ceiba.infrastructure.character.persistence.entity

import androidx.room.Embedded
import com.co.ceiba.domain.anotations.NoArg
import com.co.ceiba.domain.models.Comics

@NoArg
class ComicsEntity(
    val availableComics: Int,
    val collectionURIComics: String,
    @Embedded val itemsComics: List<ComicEntity>,
    val returnedComics: Int
) {
    constructor(comics: Comics) : this(
        availableComics = comics.available,
        collectionURIComics = comics.collectionURI,
        itemsComics = comics.items.map { ComicEntity(it) },
        returnedComics = comics.returned
    )
}