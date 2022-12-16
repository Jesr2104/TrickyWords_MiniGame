package com.justjump.trickywords.domain.usecases

import com.justjump.trickywords.data.GetPlayRepository
import com.justjump.trickywords.domain.datamodels.GameDataModel
import javax.inject.Inject

class GetPlayUsecases @Inject constructor(
    private val getPlayRepository: GetPlayRepository
) {
    fun invoke(gameSetup: GameDataModel?, onResult: (ArrayList<String>) -> Unit) = getPlayRepository.getPlayGame(gameSetup, onResult)
}