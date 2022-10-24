package com.justjump.trickywords.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.justjump.trickywords.R
import com.justjump.trickywords.ui.components.TopBarComp

@Composable
fun ProgressScreen(onClickToBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopBarComp(
                title = stringResource(R.string.title_progress),
                onClickToBack = onClickToBack)
        },
    ) { it
    }
}