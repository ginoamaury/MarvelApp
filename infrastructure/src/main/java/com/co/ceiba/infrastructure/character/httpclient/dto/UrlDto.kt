package com.co.ceiba.infrastructure.character.httpclient.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UrlDto(
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
): Parcelable