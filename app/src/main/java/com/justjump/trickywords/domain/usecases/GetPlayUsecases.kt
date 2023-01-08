package com.justjump.trickywords.domain.usecases

import android.util.Log
import com.justjump.trickywords.data.repository.GetPlayRepository
import com.justjump.trickywords.domain.datamodels.BookItem
import com.justjump.trickywords.domain.datamodels.GameDataModel
import javax.inject.Inject

class GetPlayUsecases @Inject constructor(
    private val getPlayRepository: GetPlayRepository
) {
    suspend fun invoke(gameSetup: GameDataModel?, onResult: (ArrayList<BookItem>) -> Unit){
        getPlayRepository.getPlayGame(gameSetup, onResult)
    }

}