package com.co.ceiba.infrastructure.character.persistence.entity

import androidx.room.Embedded
import com.co.ceiba.domain.anotations.NoArg
import com.co.ceiba.domain.models.Series

@NoArg
class SeriesEntity(
    val availableSeries: Int,
    val collectionURISeries: String,
    @Embedded val itemsSeries: List<SerieEntity>,
    val returnedSeries: Int
){
    constructor(series: Series): this(
        availableSeries = series.available,
        collectionURISeries = series.collectionURI,
        itemsSeries = series.items.map { SerieEntity(it) },
        returnedSeries = series.returned
    )
}