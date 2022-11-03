package com.justjump.trickywords.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun PlayGameScreen(difficultyModeValue: Int) {
    Text(text = "Nueva ventana play game Difficulty: ${difficultyModeValue}")
}