package com.co.ceiba.infrastructure.character.httpclient.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ThumbnailDto(
    @SerializedName("extension") val extension: String,
    @SerializedName("path") val path: String
): Parcelable