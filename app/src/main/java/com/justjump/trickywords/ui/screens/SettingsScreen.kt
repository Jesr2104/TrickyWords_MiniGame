package com.justjump.trickywords.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.justjump.trickywords.ui.components.TopBarComp

@Composable
fun SettiingsScreen(onClickToBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopBarComp(
                title = "Settings",
                onClickToBack = onClickToBack)
        },
    ) { it
    }
}