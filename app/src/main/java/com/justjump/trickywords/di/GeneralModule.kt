package com.justjump.trickywords.di

import com.justjump.trickywords.utilities.GeneralConstants
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
    fun provide() = GeneralConstants.NUMBER_OF_QUESTIONS_PLAY
}