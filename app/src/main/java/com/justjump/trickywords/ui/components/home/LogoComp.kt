package com.justjump.trickywords.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.justjump.trickywords.R

@Composable
fun LogoComp() {
    val image: Painter = painterResource(id = R.drawable.logo)
    Image(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.3f)
            .padding(5.dp),
        painter = image,
        contentDescription = "ApplicationLogo"
    )
}