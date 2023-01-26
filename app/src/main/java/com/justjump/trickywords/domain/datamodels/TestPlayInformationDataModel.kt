package com.justjump.trickywords.domain.datamodels


data class TestPlayInformationDataModel(
    val questions: ArrayList<QuestionTestDataModel>,
    val playerAnswers: ArrayList<Int> = arrayListOf()
) {
    fun getQuestionsList(): ArrayList<QuestionTestDataModel> {
        return questions
    }

    fun insertAnswer(answer: Int) {
        playerAnswers.add(answer)
    }

    fun checkAnswers(): ArrayList<Boolean> {
        val correctAnswers: ArrayList<Int> = arrayListOf()
        val resultTest: ArrayList<Boolean> = arrayListOf()

        for (item in questions) {
            correctAnswers.add(item.correctAnswer)
        }

        var index = 0
        while (index < playerAnswers.size){
            if (playerAnswers[index] == correctAnswers[index]){
                resultTest.add(true)
            } else {
                resultTest.add(false)
            }
            index++
        }

        return resultTest
    }

    fun getResult() {

    }
}