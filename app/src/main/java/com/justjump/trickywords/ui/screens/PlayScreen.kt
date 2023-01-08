package com.justjump.trickywords.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.justjump.trickywords.R
import com.justjump.trickywords.domain.datamodels.BookItem
import com.justjump.trickywords.domain.datamodels.GameDataModel
import com.justjump.trickywords.ui.components.TopBarComp
import com.justjump.trickywords.ui.screens.viewmodels.PlayViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlayScreen(gameSetup: GameDataModel?, onclick: () -> Unit, onClickToBack: () -> Unit) {

    // instance of the viewModel
    val viewModel = hiltViewModel<PlayViewModel>()

    // state variables to update the UI
    // ----------------------------------------------------------------
    val stepsGame: Int by viewModel.stepsGame.observeAsState(initial = 0)
    val countdown: String by viewModel.countdownStart.observeAsState(initial = "3")
    val booksList: ArrayList<BookItem> by viewModel.booksWords.observeAsState(initial = arrayListOf<BookItem>())
    // ----------------------------------------------------------------

    Scaffold(
        topBar = {
            TopBarComp(
                title = stringResource(R.string.title_play),
                onClickToBack = onClickToBack
            )
        }
    ) {
        Column {
            if (gameSetup != null) {
                when (stepsGame) {
                    // set the game an start timer.
                    0 -> {
                        viewModel.startCountdown() {
                            viewModel.changeStepsGame(1)
                        }
                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = countdown,
                                    fontSize = 85.sp,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                    // execute the game.
                    1 -> {
                        viewModel.startQuest(gameSetup)

                        LazyColumn {
                            items(booksList) {
                                Text(it.trickyWord)
                            }
                        }

                        Text("Step 2")
                        Button(
                            onClick = { viewModel.changeStepsGame(2) }
                        ) {
                            Text("Jump Step")
                        }
                    }
                    // result of te game nd show to the player.
                    2 -> {
                        Text("Step 3")
                        Button(
                            onClick = {
                                viewModel.changeStepsGame(3)
                                onclick()
                            }
                        ) {
                            Text("Exit")
                        }
                    }
                }
            }
        }
    }
}