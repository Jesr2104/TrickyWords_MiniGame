package com.justjump.trickywords.ui.components.playGame

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelectDifficultyComp(result: (Int) -> Unit) {
    Column {
        // main text on the form
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Select Difficulty",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.padding(10.dp)
            )
        }

        // buttons: Easy, Medium, Hard, Mixed
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { result(1) },
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
                Text(text = "Easy")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { result(2) },
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
                Text(text = "Medium")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { result(3) },
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
                Text(text = "Hard")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { result(4) },
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
                Text(text = "Mixed")
            }
        }
    }
}