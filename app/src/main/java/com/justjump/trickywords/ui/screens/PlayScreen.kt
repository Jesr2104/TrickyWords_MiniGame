package com.justjump.trickywords.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.justjump.trickywords.R
import com.justjump.trickywords.domain.datamodels.GameDataModel
import com.justjump.trickywords.ui.components.TopBarComp
import com.justjump.trickywords.ui.screens.viewmodels.PlayViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlayScreen(gameSetup: GameDataModel?, onClickToBack: () -> Unit) {

    // instance of the viewModel
    val viewModel = hiltViewModel<PlayViewModel>()

    // state variables to update the UI
    // ----------------------------------------------------------------
    val stepsGame: Int by viewModel.stepsGame.observeAsState(initial = 0)
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
                        Text("Step 1")
                        Button(
                            onClick = {viewModel.changeStepsGame(1)}
                        ){
                            Text("Jump Step")
                        }
                    }
                    // execute the game.
                    1 -> {
                        Text("Step 2")
                        Button(
                            onClick = {viewModel.changeStepsGame(2)}
                        ){
                            Text("Jump Step")
                        }
                    }
                    // result of te game nd show to the player.
                    2 -> {
                        Text("Step 3")
                        Button(
                            onClick = {viewModel.changeStepsGame(3)}
                        ){
                            Text("Exit")
                        }

                        //TODO("We need a button to leave back to the main menu")
                        onClickToBack()
                    }
                }
            }
        }
    }
}