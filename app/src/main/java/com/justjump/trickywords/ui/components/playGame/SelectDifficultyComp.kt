package com.justjump.trickywords.ui.components.playGame

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SelectDifficultyComp(result: (Int) -> Unit) {
    Column {
        Text(text = "Select Difficulty")
        Button(onClick = { result(1) }) {
            Text(text = "Easy")
        }

        Button(onClick = { result(2) }) {
            Text(text = "Medium")
        }

        Button(onClick = { result(3) }) {
            Text(text = "Hard")
        }

        Button(onClick = { result(4) }) {
            Text(text = "Mixed")
        }
    }
}