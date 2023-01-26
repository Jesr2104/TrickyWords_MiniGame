package com.justjump.trickywords.ui.components.test

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Option(option: String, optionNumber: Char) {
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.White,
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(1.dp, Color.Gray)

    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                text = "Option $optionNumber:",
                color = Color.Black,
                fontSize = 9.sp
            )
            Text(
                text = option,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}