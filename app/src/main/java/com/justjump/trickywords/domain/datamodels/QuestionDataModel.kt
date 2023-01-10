package com.justjump.trickywords.domain.datamodels

data class QuestionDataModel(
    val correctAnswer: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val question: String
)