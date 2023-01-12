package com.justjump.trickywords.data.repository

import com.justjump.trickywords.data.datasource.remote.BooksInfoRemoteDataSource
import com.justjump.trickywords.domain.datamodels.BookInfoDataModel
import javax.inject.Inject

class GetBooksInfoRepository @Inject constructor(
    private val booksInfoRemoteDataSource: BooksInfoRemoteDataSource
) {
    suspend fun getBookInformation(onResult: (ArrayList<BookInfoDataModel>) -> Unit) {
        booksInfoRemoteDataSource.getBooksInfo(onResult)
    }
}