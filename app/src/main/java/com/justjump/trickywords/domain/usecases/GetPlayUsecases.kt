package com.justjump.trickywords.domain.usecases

import com.justjump.trickywords.data.repository.GetPlayRepository
import com.justjump.trickywords.domain.datamodels.WordDataModel
import com.justjump.trickywords.domain.datamodels.GameDataModel
import javax.inject.Inject

class GetPlayUsecases @Inject constructor(
    private val getPlayRepository: GetPlayRepository
) {
    suspend fun invoke(gameSetup: GameDataModel?, onResult: (ArrayList<WordDataModel>) -> Unit){
        getPlayRepository.getPlayGame(gameSetup){
            // here need to happen all the proccess to preparate the test
            // 1. chose {the quantity on the const now 2 for test} word
            // 2. be sure this 2 questions are 10 with the word least used by the user
            // 1. chose 10 questions from the word chosen before
            // 3. inverte a prepare the






            onResult(it)
        }
    }

    //***********************************************************************************
    //***********************************************************************************
    fun solvertodivide() {

        // dont forget to import this library
        //import kotlin.math.*

        var numberOfQuestions = 12
        var wordsNotFrecuentPercent = 0.35
        var wordsRandomPercent = 0.65

        var wordsNotFrecuent = numberOfQuestions * wordsNotFrecuentPercent
        var wordsRandom = numberOfQuestions * wordsRandomPercent

        print("Word Not Frecuents: " + Math.round(wordsNotFrecuent))
        println()
        print("Word Random: " + Math.round(wordsRandom))

    }
    //***********************************************************************************

}
