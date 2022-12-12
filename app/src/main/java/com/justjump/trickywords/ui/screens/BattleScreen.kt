package com.justjump.trickywords.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.justjump.trickywords.R
import com.justjump.trickywords.ui.components.TopBarComp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BattleScreen(onClickToBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopBarComp(
                title = stringResource(R.string.title_battle),
                onClickToBack = onClickToBack
            )
        }
    ) {
        Column {
            Row { Text(text = "<- Battle ->") }
        }
    }
}