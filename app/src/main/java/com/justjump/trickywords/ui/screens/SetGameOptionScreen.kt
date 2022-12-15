package com.justjump.trickywords.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.justjump.trickywords.domain.datamodels.GameDataModel
import com.justjump.trickywords.ui.components.TopBarComp
import com.justjump.trickywords.ui.components.DifficultySelectorComp
import com.justjump.trickywords.ui.components.BookSelectorComp

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
                                BookSelectorComp {
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
                                DifficultySelectorComp {
                                    state = 0
                                    game.difficult = it
                                    onclickPlay(game)
                                }
                            }
                        }
                    }
                }
            }
            2 -> {
                Column {
                    // Option to Battle Game.
                    // 1. Select the book of the play.
                    titleScreen = "Battle"
                    when (state) {
                        0 -> {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                BookSelectorComp {
                                    state = 0
                                    game.bookNumber = it
                                    onclickBattle(game)
                                }
                            }
                        }
                    }
                }
            }
            3 -> {
                Column {
                    // Option to Word List.
                    // 1. Select the book for the Word List.
                    titleScreen = "Word List"
                    when (state) {
                        0 -> {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                BookSelectorComp {
                                    state = 0
                                    game.bookNumber = it
                                    onclickWordList(game)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}