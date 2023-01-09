package com.justjump.trickywords.di

import com.justjump.trickywords.domain.datamodels.BookItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/books")
    suspend fun getBooks(): Response<ArrayList<BookItem>>

    @GET("/books/{bookNumber}")
    suspend fun getBookSpec(@Path("bookNumber") bookNumber: Int): Response<ArrayList<BookItem>>

    @GET("/words")
    suspend fun getWords(): Response<ArrayList<BookItem>>

    @GET("/words/{word}")
    suspend fun getWordSpec(@Path("word") word: String): Response<ArrayList<BookItem>>
}