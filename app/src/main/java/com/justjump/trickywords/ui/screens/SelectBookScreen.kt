package com.justjump.trickywords.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.justjump.trickywords.domain.InfoPlayGame
import com.justjump.trickywords.ui.components.TopBarComp
import com.justjump.trickywords.ui.components.selectBook.ViewPageBookSelectorComp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SelectBookScreen(gameMode: Int, onClick: (InfoPlayGame) -> Unit, onClickToBack: () -> Unit) {
    Scaffold(topBar = { TopBarComp(onClickToBack = onClickToBack) })
    {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Select a Book",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(10.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) { ViewPageBookSelectorComp(gameMode, onClick) }
        }
    }
}