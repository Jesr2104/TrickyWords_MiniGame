package com.justjump.trickywords.domain.datamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookInfomationDataModel(
    val ISBN: String,
    val bookName: String,
    val bookNumber: Int,
    val difficultLevel: String,
    val numberOfLesson: Int,
    val rangeLesson: String,
    val image: String,
    var enable: Boolean = true
): Parcelable