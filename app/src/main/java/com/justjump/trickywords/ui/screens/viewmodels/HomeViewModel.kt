package com.justjump.trickywords.ui.screens.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.justjump.trickywords.domain.usecases.GetBooksInfoUseCases
import com.justjump.trickywords.utilities.BooksInformation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private var getBooksInfoUseCases: GetBooksInfoUseCases
) : ViewModel() {

    fun checkActiveBooks() = viewModelScope.launch {
        getBooksInfoUseCases.invoke{
            BooksInformation.setBooksInformationList(it)
        }
    }
}