package com.justjump.trickywords.data.datasource.remote

import com.justjump.trickywords.di.ApiService
import com.justjump.trickywords.domain.datamodels.WordDataModel
import com.justjump.trickywords.domain.datamodels.GameDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BooksRemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getWordsFromABook(
        gameSetup: GameDataModel?,
        onResult: (ArrayList<WordDataModel>) -> Unit
    ) {
        return withContext(Dispatchers.IO) {
            val response = apiService.getBookSpec(gameSetup!!.bookNumber)
            val result = response.body() ?: arrayListOf()
            onResult(result)
        }
    }
}