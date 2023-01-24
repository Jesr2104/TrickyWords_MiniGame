package com.justjump.trickywords.domain.usecases

import com.justjump.trickywords.data.repository.GetPlayRepository
import com.justjump.trickywords.di.GeneralModule.provideNumberOfQuestionsPlay
import com.justjump.trickywords.domain.datamodels.*
import javax.inject.Inject

class GetPlayUsecases @Inject constructor(
    private val getPlayRepository: GetPlayRepository
) {
    suspend fun invoke(
        gameSetup: GameDataModel?,
        onResult: (PlayGameStructureDataModel) -> Unit
    ) {
        getPlayRepository.getPlayGame(gameSetup) {
            // Order tasks
            // 1. selected the number of the questions {numberOfQuestions}
            //      35% - Words not frecuent used
            //      65% - Words random
            // 2.

            // solution implementation
            // =================================================
            onResult(allJobs(gameSetup, it))
            // =================================================
        }
    }

    // function prepare the object for the test to play
    private fun allJobs(
        gameSetup: GameDataModel?, wordDataModels: ArrayList<WordDataModel>
    ): PlayGameStructureDataModel {
        // step 1: filter the data with difficulty selected
        val dataFilter = filterDifficulty(gameSetup, wordDataModels)

        // step 2: get the questions and prepare it for the test and return it's
        return PlayGameStructureDataModel( questions = getQuestions(dataFilter))
    }

    // function to filter the list of the trickwords for the difficulty selectec
    private fun filterDifficulty(
        gameSetup: GameDataModel?, wordDataModels: ArrayList<WordDataModel>
    ): ArrayList<WordDataModel> {
        var tempFilter: ArrayList<WordDataModel> = arrayListOf()

        // handle the selection of the words when the user selected a specific difficutly
        // and if it's not true the else control when the difficulty is mix.
        if (gameSetup!!.difficult != 4){
            for (item in wordDataModels) {
                if (item.difficulty == gameSetup!!.difficult) {
                    tempFilter.add(item)
                }
            }
        } else {
            tempFilter = wordDataModels
        }
        return tempFilter
    }

    // function to select the randon questions and prepare the list for the
    private fun getQuestions(wordDataModels: ArrayList<WordDataModel>): ArrayList<QuestionTestDataModel> {
        val questionsList: ArrayList<QuestionTestDataModel> = arrayListOf()
        val indexList =
            (0 until wordDataModels.size).shuffled().take(provideNumberOfQuestionsPlay())

        for (it in indexList) {
            val randQuestions = wordDataModels[it].questions.shuffled()[0]
            val newItem = QuestionTestDataModel(
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

    private fun prepareQuests(questions: QuestionTestDataModel): QuestionTestDataModel {
        val correctAnswer = questions.options[questions.correctAnswer]
        val mixesOptions = questions.options.shuffled()

        return QuestionTestDataModel(
            trickyWord = questions.trickyWord,
            question = questions.question,
            correctAnswer = mixesOptions.indexOf(correctAnswer),
            options = mixesOptions
        )
    }


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
