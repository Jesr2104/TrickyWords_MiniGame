package com.justjump.trickywords.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.justjump.trickywords.domain.InfoPlayGame
import com.justjump.trickywords.ui.components.TopBarComp

@Composable
fun PlayGame(gameMode: InfoPlayGame?, onClickToBack: () -> Unit) {
    Scaffold(topBar = { TopBarComp(onClickToBack = onClickToBack) })
    { it
        Column {
            if (gameMode != null){
                Text(text = "GameMode: ${gameMode!!.gameMode}")
                Text(text = "Book Number: ${gameMode!!.bookNumber}")
            }
        }
    }
}