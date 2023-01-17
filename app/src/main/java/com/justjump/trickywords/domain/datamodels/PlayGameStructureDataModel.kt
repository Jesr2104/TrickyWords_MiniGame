package com.justjump.trickywords.domain.datamodels


data class PlayGameStructure(
    val questions: ArrayList<QuestionTestDataModel>,
    val playerAnswers: List<Int> = arrayListOf()
) {
    fun checkAnswers() {
    }
    fun getResult() {

    }
}