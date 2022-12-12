package com.justjump.trickywords.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.justjump.trickywords.domain.datamodels.GameDataModel
import com.justjump.trickywords.ui.components.TopBarComp
import com.justjump.trickywords.ui.components.playGame.SelectDifficultyComp
import com.justjump.trickywords.ui.components.selectBook.ViewPageBookSelectorComp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SetGameOptionScreen(
    modeSelected: Int,
    onclickPlay: (GameDataModel) -> Unit,
    onclickBattle: (GameDataModel) -> Unit,
    onclickWordList: (GameDataModel) -> Unit,
    onClickToBack: () -> Unit
) {
    val game = GameDataModel()
    var state by rememberSaveable { mutableStateOf(0) }
    var titleScreen by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopBarComp(
                title = titleScreen,
                onClickToBack = onClickToBack
            )
        }
    ) {
        when (modeSelected) {
            1 -> {
                Column {
                    // Option to Play Game.
                    // 1. Select the book of the play.
                    // 2. select the difficult of the game.
                    titleScreen = "Play"
                    when (state) {
                        0 -> {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                ViewPageBookSelectorComp() {
                                    game.bookNumber = it
                                    state = 1
                                }
                            }
                        }
                        1 -> {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                SelectDifficultyComp {
                                    game.difficult = it
                                    state = 2
                                }
                            }
                        }
                        2 -> {
                            // setup ready
                            state = 0 // reset the state
                            onclickPlay(game)
                        }
                    }
                }
            }
            2 -> {
                Column {
                    titleScreen = "Battle"
                }
            }
            3 -> {
                Column {
                    titleScreen = "Word List"
                }
            }
        }
    }
}