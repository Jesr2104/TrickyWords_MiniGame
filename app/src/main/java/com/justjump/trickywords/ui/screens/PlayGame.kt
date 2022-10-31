package com.justjump.trickywords.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.justjump.trickywords.domain.InfoPlayGame

@Composable
fun PlayGame(gameMode: InfoPlayGame?) {
    Text(text = "PlayGame ${gameMode!!.gameMode}")
}