package com.justjump.trickywords.ui.components.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainOptionsComp(
    onClick: (Int) -> Unit,
    onClickProgress: () -> Unit,
    onClickSettings: () -> Unit,
    onClickClose: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth())
    {
        // Option to Play Game
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { onClick(1) },
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
                Text(text = "Play")
            }
        }

        // Option to Battle
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { onClick(2) },
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
                Text(text = "Battle")
            }
        }

        // Option to Word List
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { onClick(3) },
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
                Text(text = "Word list")
            }
        }

        // Option to Show Progress
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { onClickProgress() },
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
                Text(text = "Progress")
            }
        }

        // Option to Settings
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { onClickSettings() },
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
                Text(text = "Setting")
            }
        }

        // Option to Exit
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { onClickClose() },
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
                Text(text = "Exit")
            }
        }
    }
}

