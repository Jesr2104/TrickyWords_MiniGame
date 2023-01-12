package com.justjump.trickywords.domain.datamodels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookInfoDataModel(
    val ISBN: String,
    val bookName: String,
    val bookNumber: Int,
    val difficulty: String,
    val nLesson: Int,
    val rangeLesson: String,
    val image: String,
    @SerializedName("active")
    var isActive: Boolean = true
): Parcelable