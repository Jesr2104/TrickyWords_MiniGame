package com.justjump.trickywords.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.justjump.trickywords.ui.components.home.LogoComp
import com.justjump.trickywords.ui.components.home.MainOptionsComp
import com.justjump.trickywords.ui.components.home.TitleAppComp

@Composable
fun HomeScreen(
    onClick_Play_Battle_WordList: (Int) -> Unit,
    onClickProgress: () -> Unit,
    onClickSettings: () -> Unit,
    onClickClose: () -> Unit
) {
    Scaffold { it
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            // Title
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                TitleAppComp("TrickyWords")
            }

            // Logo
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                LogoComp()
            }

            // Main Menu
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                MainOptionsComp(onClick_Play_Battle_WordList, onClickProgress, onClickSettings, onClickClose)
            }
        }
    }
}