package com.justjump.trickywords.domain.datamodels

data class WordDataModel(
    val difficulty: Int,
    val idTrickyWord: String,
    val nBook: Int,
    val nLesson: Int,
    val questionDataModels: List<QuestionDataModel>,
    val trickyWord: String,
    val type: Int
)