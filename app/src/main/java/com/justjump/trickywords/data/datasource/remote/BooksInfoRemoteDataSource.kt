package com.justjump.trickywords.data.datasource.remote

import com.justjump.trickywords.di.ApiService
import com.justjump.trickywords.domain.datamodels.BookInfoDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BooksInfoRemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getBooksInfo(
        onResult: (ArrayList<BookInfoDataModel>) -> Unit
    ){
        return withContext(Dispatchers.IO){
            val response = apiService.getBooksInformation()
            val result = response.body() ?: arrayListOf()
            onResult(result)
        }
    }
}