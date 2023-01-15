package com.justjump.trickywords.domain.usecases

import android.util.Log
import com.justjump.trickywords.data.repository.GetPlayRepository
import com.justjump.trickywords.domain.datamodels.WordDataModel
import com.justjump.trickywords.domain.datamodels.GameDataModel
import javax.inject.Inject

class GetPlayUsecases @Inject constructor(
    private val getPlayRepository: GetPlayRepository
) {
    companion object{
        // this need to be exporter outside
        var questionNumber = 8
    }
    suspend fun invoke(gameSetup: GameDataModel?, onResult: (ArrayList<WordDataModel>) -> Unit){
        getPlayRepository.getPlayGame(gameSetup){
            // Order tasks
            // 0. selected just the words with the difficulty selected
            // 1. selected the number of the questions {numberOfQuestions}
            //      35% - Words not frecuent used
            //      65% - Words random
            // 2. select the questions that the test will use
            //      a. create a class to store all the questions
            // 3. return the new list

            Log.e("jesr", "${it}")

            onResult(it)
        }
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
