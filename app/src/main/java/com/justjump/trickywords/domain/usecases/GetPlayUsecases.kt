package com.justjump.trickywords.domain.usecases

import com.justjump.trickywords.data.repository.GetPlayRepository
import com.justjump.trickywords.di.GeneralModule.provideNumberOfQuestionsPlay
import com.justjump.trickywords.domain.datamodels.GameDataModel
import com.justjump.trickywords.domain.datamodels.WordDataModel
import javax.inject.Inject

class GetPlayUsecases @Inject constructor(
    private val getPlayRepository: GetPlayRepository
) {
    suspend fun invoke(gameSetup: GameDataModel?, onResult: (ArrayList<Question>) -> Unit) {
        getPlayRepository.getPlayGame(gameSetup) {
            // Order tasks
            // 0. selected just the words with the difficulty selected
            // 1. selected the number of the questions {numberOfQuestions}
            //      35% - Words not frecuent used
            //      65% - Words random
            // 2. select the questions that the test will use
            //      a. create a class to store all the questions
            // 3. return the new list

            // solution implementation
            // =================================================
            onResult(allJobs(gameSetup, it))
            // =================================================






            //+++++++++++++++++++++++++++++++++++++++++++++++++++
            //+++++++++++++++++++++++++++++++++++++++++++++++++++
            //+++++++++++++++++++++++++++++++++++++++++++++++++++
            //  Miss the option to mix the dificulty
            //+++++++++++++++++++++++++++++++++++++++++++++++++++
            //+++++++++++++++++++++++++++++++++++++++++++++++++++
            //+++++++++++++++++++++++++++++++++++++++++++++++++++

        }
    }

    data class Question(
        val trickyWord: String,
        val question: String,
        val correctAnswer: Int,
        val options: List<String>
    )

    private fun allJobs(
        gameSetup: GameDataModel?,
        wordDataModels: ArrayList<WordDataModel>
    ): ArrayList<Question> {
        // step 1: filter the data with difficulty selected
        val dataFilter = filterDifficulty(gameSetup, wordDataModels)

        // step 2: get the questions and prepare it for the test and return it's
        return getQuestions(dataFilter)
    }

    private fun getQuestions(wordDataModels: ArrayList<WordDataModel>): ArrayList<Question> {
        val questionsList: ArrayList<Question> = arrayListOf()
        val indexList =
            (0 until wordDataModels.size).shuffled().take(provideNumberOfQuestionsPlay())

        for (it in indexList) {
            val randQuestions = wordDataModels[it].questions.shuffled()[0]
            val newItem = Question(
                trickyWord = wordDataModels[it].trickyWord,
                question = randQuestions.question,
                correctAnswer = 0,
                options = listOf(
                    randQuestions.correctAnswer,
                    randQuestions.optionA,
                    randQuestions.optionB,
                    randQuestions.optionC,
                )
            )
            questionsList.add(prepareQuests(newItem))
        }
        return questionsList
    }

    private fun prepareQuests(questions: Question): Question {
        val correctAnswer = questions.options[questions.correctAnswer]
        val mixesOptions = questions.options.shuffled()

        return Question(
            trickyWord = questions.trickyWord,
            question = questions.question,
            correctAnswer = mixesOptions.indexOf(correctAnswer),
            options = mixesOptions
        )
    }

    private fun filterDifficulty(
        gameSetup: GameDataModel?,
        wordDataModels: ArrayList<WordDataModel>
    ): ArrayList<WordDataModel> {
        val tempFilter: ArrayList<WordDataModel> = arrayListOf()
        for (item in wordDataModels) {
            if (item.difficulty == gameSetup!!.difficult) {
                tempFilter.add(item)
            }
        }
        return tempFilter
    }

    //***********************************************************************************
    //***********************************************************************************
//    fun solvertodivide() {
//
//        // dont forget to import this library
//        //import kotlin.math.*
//
//        var numberOfQuestions = 12
//        var wordsNotFrecuentPercent = 0.35
//        var wordsRandomPercent = 0.65
//
//        var wordsNotFrecuent = numberOfQuestions * wordsNotFrecuentPercent
//        var wordsRandom = numberOfQuestions * wordsRandomPercent
//
//        print("Word Not Frecuents: " + Math.round(wordsNotFrecuent))
//        println()
//        print("Word Random: " + Math.round(wordsRandom))
//
//    }
    //***********************************************************************************

}
