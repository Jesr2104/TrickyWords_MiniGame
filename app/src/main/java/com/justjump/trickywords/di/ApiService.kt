package com.justjump.trickywords.di

import com.justjump.trickywords.domain.datamodels.BookInfoDataModel
import com.justjump.trickywords.domain.datamodels.WordDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/books")
    suspend fun getBooks(): Response<ArrayList<WordDataModel>>

    @GET("/books/{bookNumber}")
    suspend fun getBookSpec(@Path("bookNumber") bookNumber: Int): Response<ArrayList<WordDataModel>>

    @GET("/words")
    suspend fun getWords(): Response<ArrayList<WordDataModel>>

    @GET("/words/{word}")
    suspend fun getWordSpec(@Path("word") word: String): Response<ArrayList<WordDataModel>>

    // function to get the information of the books
    // (ISBN, name, number, difficult, image, nLesson, rangeLesson, isActive)
    @GET("/info/books")
    suspend fun getBooksInformation(): Response<ArrayList<BookInfoDataModel>>
}