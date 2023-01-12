package com.justjump.trickywords.domain.datamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class QuestionDataModel(
    val correctAnswer: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val question: String
): Parcelable