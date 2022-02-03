package com.co.ceiba.infrastructure.character.httpclient.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharactersDto(
    @SerializedName("attributionHTML") val attributionHTML: String,
    @SerializedName("attributionText") val attributionText: String,
    @SerializedName("code") val code: Int,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("data") val dataDto: DataDto,
    @SerializedName("etag") val etag: String,
    @SerializedName("status") val status: String
) : Parcelable