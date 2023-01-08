package com.justjump.trickywords.domain.datamodels

data class BookItem(
    val difficulty: Int,
    val idTrickyWord: String,
    val nBook: Int,
    val nLesson: Int,
    val questions: List<Question>,
    val trickyWord: String,
    val type: Int
)