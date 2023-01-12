package com.justjump.trickywords.domain.datamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WordDataModel(
    val difficulty: Int,
    val idTrickyWord: String,
    val nBook: Int,
    val nLesson: Int,
    val questionDataModels: List<QuestionDataModel>,
    val trickyWord: String,
    val type: Int
): Parcelable