package com.justjump.trickywords.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.justjump.trickywords.R
import com.justjump.trickywords.domain.datamodels.GameDataModel
import com.justjump.trickywords.domain.datamodels.QuestionTestDataModel
import com.justjump.trickywords.domain.datamodels.TestPlayInformationDataModel
import com.justjump.trickywords.ui.components.TopBarComp
import com.justjump.trickywords.ui.components.test.Option
import com.justjump.trickywords.ui.components.test.Question
import com.justjump.trickywords.ui.screens.viewmodels.PlayViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlayScreen(gameSetup: GameDataModel?, onclick: () -> Unit, onClickToBack: () -> Unit) {

    // instance of the viewModel
    val viewModel = hiltViewModel<PlayViewModel>()

    // var to control the once execution of the code
    var checkExecute: Boolean by remember { mutableStateOf(true) }
    var numberOfQuestions: Int by remember { mutableStateOf(0) }

    // state variables to update the UI
    // ----------------------------------------------------------------
    val stepsGame: Int by viewModel.stepsGame.observeAsState(initial = 0)
    val countdown: String by viewModel.countdownStart.observeAsState(initial = "3")
    val booksList: ArrayList<QuestionTestDataModel> by viewModel.booksWords.observeAsState(
        initial = arrayListOf()
    )
    val testPlay: TestPlayInformationDataModel by viewModel.testInformation.observeAsState(
        initial = TestPlayInformationDataModel(
            arrayListOf()
        )
    )
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
                        // Call to request of the API for the questions
                        // this code use the countdown to get the request ready
                        // ----------------------------------------------
                        if (checkExecute) {
                            viewModel.startQuest(gameSetup)
                            checkExecute = false
                        }
                        // ----------------------------------------------

                        viewModel.startCountdown {
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
                        if (booksList.size == 0) {
                            Column {
                                Row {
                                    Text("not enough words have been found for this test try another book!!")
                                }
                            }
                        } else if(numberOfQuestions < booksList.size) {
                            val item = testPlay.getQuestionsList()[numberOfQuestions]

                            Text(
                                text = "${numberOfQuestions + 1}/${testPlay.questions.size}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .padding(10.dp, 4.dp, 0.dp, 4.dp)
                            )

                            // Questions
                            Question(item.question)

                            // Timer
                            Text("Timer")

                            // Options
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                // Option A
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                                    .clickable {
                                        numberOfQuestions++
                                    }
                                ) {
                                    Option(item.options[0], 'A')
                                }

                                // Option B
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                                    .clickable {
                                        numberOfQuestions++
                                    }
                                ) {
                                    Option(item.options[1], 'B')
                                }

                                // Option C
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                                    .clickable {
                                        numberOfQuestions++
                                    }
                                ) {
                                    Option(item.options[2], 'C')
                                }

                                // Option D
                                Row(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                                    .clickable {
                                        numberOfQuestions++
                                    }
                                ) {
                                    Option(item.options[3], 'C')
                                }
                            }
                        } else {
                            // finish test
                            viewModel.changeStepsGame(2)
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