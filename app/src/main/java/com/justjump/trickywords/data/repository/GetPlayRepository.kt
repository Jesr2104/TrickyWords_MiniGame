package com.justjump.trickywords.data.repository

import com.justjump.trickywords.data.datasource.remote.BooksRemoteDataSource
import com.justjump.trickywords.domain.datamodels.WordDataModel
import com.justjump.trickywords.domain.datamodels.GameDataModel
import javax.inject.Inject

class GetPlayRepository @Inject constructor(
    private val booksRemoteDataSource: BooksRemoteDataSource
) {
    suspend fun getPlayGame(gameSetup: GameDataModel?, onResult: (ArrayList<WordDataModel>) -> Unit) {
        booksRemoteDataSource.getWordsFromABook(gameSetup , onResult)
    }
}