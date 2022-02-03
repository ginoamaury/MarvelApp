package com.co.ceiba.infrastructure.character.persistence.entity

import androidx.room.Embedded
import com.co.ceiba.domain.anotations.NoArg
import com.co.ceiba.domain.models.Events

@NoArg
class EventsEntity(
    val availableEvents: Int,
    val collectionURIEvents: String,
    @Embedded val itemsEvents: List<EventEntity>,
    val returnedEvents: Int
){
    constructor(events: Events): this(
        availableEvents = events.available,
        collectionURIEvents = events.collectionURI,
        itemsEvents = events.items.map { EventEntity(it) },
        returnedEvents = events.returned
    )
}