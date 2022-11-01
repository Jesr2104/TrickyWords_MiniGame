package com.justjump.trickywords.ui.components.playGame

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SelectDifficultyComp() {
    Column {
        Button(onClick = {}) {
            Text(text = "Easy")
        }

        Button(onClick = {}) {
            Text(text = "Medium")
        }

        Button(onClick = {}) {
            Text(text = "Hard")
        }

        Button(onClick = {}) {
            Text(text = "Mixed")
        }
    }
}