package com.justjump.trickywords.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.justjump.trickywords.ui.components.TopBarComp

@Composable
fun ProgressScreen(onClickToBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopBarComp(
                title = "Progress",
                onClickToBack = onClickToBack)
        },
    ) { it
    }
}