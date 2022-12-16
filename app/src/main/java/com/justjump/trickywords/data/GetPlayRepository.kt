package com.justjump.trickywords.data

import com.justjump.trickywords.data.datasource.remote.GetAllRemoteDataSource
import com.justjump.trickywords.domain.datamodels.GameDataModel
import javax.inject.Inject

class GetPlayRepository @Inject constructor(
    private val getAllRemoteDataSource: GetAllRemoteDataSource
) {
    // list of the trickyWord from the book and difficulty selected
    val trickyWords = arrayListOf<String>()

    fun getPlayGame(gameSetup: GameDataModel?, onResult: (ArrayList<String>) -> Unit) {

        getAllRemoteDataSource.getTrickyWordOfBook(gameSetup)


        onResult(trickyWords)
    }
}