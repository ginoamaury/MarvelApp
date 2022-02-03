package com.co.ceiba.infrastructure.character.httpclient.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataDto(
    @SerializedName("count") val count: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("results") val charactersDto: List<CharacterDto>,
    @SerializedName("total") val total: Int
): Parcelable