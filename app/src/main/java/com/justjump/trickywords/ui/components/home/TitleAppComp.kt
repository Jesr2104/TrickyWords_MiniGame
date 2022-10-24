package com.justjump.trickywords.ui.components.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TitleAppComp(title: String) {
    Box(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(
            title,
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
    }
}