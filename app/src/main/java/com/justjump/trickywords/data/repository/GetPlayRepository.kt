package com.justjump.trickywords.data.repository

import com.justjump.trickywords.data.datasource.remote.GetAllRemoteDataSource
import com.justjump.trickywords.domain.datamodels.WordDataModel
import com.justjump.trickywords.domain.datamodels.GameDataModel
import javax.inject.Inject

class GetPlayRepository @Inject constructor(
    private val getAllRemoteDataSource: GetAllRemoteDataSource
) {
    // list of the trickyWord from the book and difficulty selected
    val trickyWords = ArrayList<WordDataModel>()

    suspend fun getPlayGame(gameSetup: GameDataModel?, onResult: (ArrayList<WordDataModel>) -> Unit) {
        getAllRemoteDataSource.getTrickyWordOfBook(gameSetup , onResult)
    }
}