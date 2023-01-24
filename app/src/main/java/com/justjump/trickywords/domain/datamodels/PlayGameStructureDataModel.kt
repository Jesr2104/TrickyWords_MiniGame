package com.justjump.trickywords.domain.datamodels


data class PlayGameStructureDataModel(
    val questions: ArrayList<QuestionTestDataModel>,
    val playerAnswers: List<Int> = arrayListOf()
) {
    fun getQuestionsList(): ArrayList<QuestionTestDataModel> {
        return questions
    }
    fun checkAnswers() {
    }
    fun getResult() {

    }
}