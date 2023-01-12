package com.justjump.trickywords.domain.usecases

import com.justjump.trickywords.data.repository.GetBooksInfoRepository
import com.justjump.trickywords.domain.datamodels.BookInfoDataModel
import javax.inject.Inject

class GetBooksInfoUseCases @Inject constructor(
    private var getBooksInfoRepository: GetBooksInfoRepository
) {
    suspend fun invoke(onResult: (ArrayList<BookInfoDataModel>) -> Unit) {
        getBooksInfoRepository.getBookInformation(onResult)
    }
}