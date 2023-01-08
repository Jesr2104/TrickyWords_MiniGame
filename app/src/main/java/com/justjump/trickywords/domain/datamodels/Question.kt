package com.justjump.trickywords.domain.datamodels

data class Question(
    val correctAnswer: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val question: String
)