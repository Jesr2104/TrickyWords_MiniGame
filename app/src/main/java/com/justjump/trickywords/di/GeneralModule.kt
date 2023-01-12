package com.justjump.trickywords.di

import com.justjump.trickywords.utilities.BooksInformation
import com.justjump.trickywords.utilities.GeneralSetting
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GeneralModule {

    @Singleton
    @Provides
    fun provide() = GeneralSetting.nQuetionsPlay

    @Singleton
    @Provides
    fun provideBooksInformation() = BooksInformation.getBooksInformationList()
}