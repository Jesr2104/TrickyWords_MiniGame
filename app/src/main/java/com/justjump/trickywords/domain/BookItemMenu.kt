package com.justjump.trickywords.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookItemMenu(
    val ISBN: String,
    val bookName: String,
    val bookNumber: Int,
    val difficultLevel: String,
    val numberOfLesson: Int,
    val rangeLesson: String,
    val image: String
): Parcelable


