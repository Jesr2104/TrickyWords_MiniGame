package com.justjump.trickywords.data.datasource.remote

import com.justjump.trickywords.di.ApiService
import com.justjump.trickywords.domain.datamodels.BookItem
import com.justjump.trickywords.domain.datamodels.GameDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAllRemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getTrickyWordOfBook(
        gameSetup: GameDataModel?,
        onResult: (ArrayList<BookItem>) -> Unit
    ) {
        return withContext(Dispatchers.IO) {
            val response = apiService.getBookSpec(gameSetup!!.bookNumber)
            val result = response.body() ?: arrayListOf()
            onResult(result)
        }
    }
}