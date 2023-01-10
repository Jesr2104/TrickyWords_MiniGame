package com.justjump.trickywords.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.justjump.trickywords.ui.components.home.LogoComp
import com.justjump.trickywords.ui.components.home.MainOptionsComp
import com.justjump.trickywords.ui.components.home.TitleAppComp
import com.justjump.trickywords.ui.screens.viewmodels.HomeViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onClick_Play_Battle_WordList: (Int) -> Unit,
    onClickProgress: () -> Unit,
    onClickSettings: () -> Unit,
    onClickClose: () -> Unit
) {
    // instance of the viewModel
    val viewModel = hiltViewModel<HomeViewModel>()

    // call the function to check if any book was disable
    viewModel.checkAvtiveBooks()

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            // Title
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                TitleAppComp("TrickyWords")
            }

            // Logo
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                LogoComp()
            }

            // Main Menu
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                MainOptionsComp(
                    onClick_Play_Battle_WordList,
                    onClickProgress,
                    onClickSettings,
                    onClickClose
                )
            }
        }
    }
}