package com.justjump.trickywords.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.justjump.trickywords.R
import com.justjump.trickywords.domain.datamodels.GameDataModel
import com.justjump.trickywords.ui.components.TopBarComp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlayScreen(gameSetup: GameDataModel?, onClickToBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopBarComp(
                title = stringResource(R.string.title_play),
                onClickToBack = onClickToBack
            )
        }
    ) {
        Column {
            Row { Text(text = "<- Play ->") }
            if (gameSetup != null) {
                Row { Text("Book Number: ${gameSetup.bookNumber}") }
                Row { Text("Defficult: ${gameSetup.difficult}") }
            }
        }
    }
}