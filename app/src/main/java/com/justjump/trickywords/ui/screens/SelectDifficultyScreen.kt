package com.justjump.trickywords.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.justjump.trickywords.domain.InfoPlayGame
import com.justjump.trickywords.ui.components.TopBarComp
import com.justjump.trickywords.ui.components.playGame.SelectDifficultyComp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SelectDifficultyScreen(infoGame: InfoPlayGame?, onClickToBack: () -> Unit) {
    Scaffold(topBar = { TopBarComp(onClickToBack = onClickToBack) })
    {
        Column {
            if (infoGame != null){
                when (infoGame.gameMode) {
                    1 -> {
                        Text(text = "Select Difficulty")
                        SelectDifficultyComp {
                            when(it){
                                1 -> {}
                                2 -> {}
                                3 -> {}
                                4 -> {}
                            }
                        }
                    }
                    2 -> {
                        Text(text = "Battle")
                        Text(text = "Book Number: ${infoGame.bookNumber}")
                    }
                    3 -> {
                        Text(text = "Word List")
                        Text(text = "Book Number: ${infoGame.bookNumber}")
                    }
                }
            }
        }
    }
}