package com.justjump.trickywords.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.justjump.trickywords.ui.components.TopBarComp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SetGameOptionScreen(modeSelected: Int, onClickToBack: () -> Unit) {
    Scaffold(topBar = { TopBarComp(onClickToBack = onClickToBack) })
    {
        when (modeSelected) {
            1 -> {
                Column {
                    Row { Text(text = "<- Play Game ->") }
                }
            }
            2 -> {
                Column {
                    Row { Text(text = "<- Battle ->") }
                }
            }
            3 -> {
                Column {
                    Row { Text(text = "<- Word List ->") }
                }
            }
        }
    }
}