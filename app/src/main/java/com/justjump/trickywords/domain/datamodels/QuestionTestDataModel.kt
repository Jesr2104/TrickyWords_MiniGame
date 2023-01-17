package com.justjump.trickywords.domain.datamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuestionTestDataModel(
    val trickyWord: String,
    val question: String,
    val correctAnswer: Int,
    val options: List<String>
): Parcelable