package com.justjump.trickywords.di

import com.justjump.trickywords.domain.datamodels.BookItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/books/${7}")
    suspend fun getBook(): Response<ArrayList<BookItem>>
}