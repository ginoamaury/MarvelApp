package com.co.ceiba.infrastructure.character.httpclient.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ComicDto(
    @SerializedName("name") val name: String,
    @SerializedName("resourceURI") val resourceURI: String
): Parcelable