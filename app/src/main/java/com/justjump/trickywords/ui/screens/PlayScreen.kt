package com.justjump.trickywords.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.justjump.trickywords.di.GeneralModule.provideNumberOfQuestionsPlay
import com.justjump.trickywords.domain.datamodels.WordDataModel
import com.justjump.trickywords.domain.datamodels.GameDataModel
import com.justjump.trickywords.domain.datamodels.QuestionTestDataModel
import com.justjump.trickywords.domain.datamodels.TestPlayInformationDataModel
import com.justjump.trickywords.domain.usecases.GetPlayUsecases
import com.justjump.trickywords.ui.components.TopBarComp
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
                        } else {
                            val item = testPlay.getQuestionsList()[numberOfQuestions]

                            Text("${numberOfQuestions + 1}/${testPlay.questions.size}")
                            Text(item.question)
                            Text("Temporizador")

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(0.35f)
                            ) {
                                Column{
                                    Row(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(2.dp)
                                    ) {
                                        // Option A
                                        Column(
                                            modifier = Modifier
                                                .background(Color.LightGray)
                                                .fillMaxHeight()
                                                .weight(1f)
                                                .clickable {
                                                    numberOfQuestions++
                                                }
                                        ) { Text(item.options[0]) }
                                        Spacer(modifier = Modifier.width(2.dp))
                                        // Option B
                                        Column(
                                            modifier = Modifier
                                                .background(Color.LightGray)
                                                .fillMaxHeight()
                                                .weight(1f)
                                                .clickable {
                                                    numberOfQuestions++
                                                }
                                        ) { Text(item.options[1]) }
                                    }
                                    Row(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(2.dp)
                                    ) {
                                        // Option C
                                        Column(
                                            modifier = Modifier
                                                .background(Color.LightGray)
                                                .fillMaxHeight()
                                                .weight(1f)
                                                .clickable {
                                                    numberOfQuestions++
                                                }
                                        ) { Text(item.options[2]) }
                                        Spacer(modifier = Modifier.width(2.dp))
                                        // Option D
                                        Column(
                                            modifier = Modifier
                                                .background(Color.LightGray)
                                                .fillMaxHeight()
                                                .weight(1f)
                                                .clickable {
                                                    numberOfQuestions++
                                                }
                                        ) { Text(item.options[3]) }
                                    }
                                }
                            }


//                            LazyColumn {
//                                items(booksList) {
//                                    Column {
//                                        Row {
//                                            Text("Trickyword: " + it.trickyWord)
//                                            Text("")
//                                        }
//                                        Row {
//                                            Text("Question: " + it.question)
//                                            Text("")
//                                            Text("")
//                                        }
//                                        Row { Text("Option A: " + it.options[0]) }
//                                        Row { Text("Option B: " + it.options[1]) }
//                                        Row { Text("Option C: " + it.options[2]) }
//                                        Row { Text("Option D: " + it.options[3]) }
//                                        Text("")
//                                        Text("")
//                                    }
//                                }
//                            }
                        }

                        Text("")
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