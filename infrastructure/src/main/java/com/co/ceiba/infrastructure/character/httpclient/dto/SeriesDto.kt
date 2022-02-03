package com.co.ceiba.infrastructure.character.httpclient.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SeriesDto(
    @SerializedName("available") val available: Int,
    @SerializedName("collectionURI") val collectionURI: String,
    @SerializedName("items") val items: List<SerieDto>,
    @SerializedName("returned") val returned: Int
): Parcelable