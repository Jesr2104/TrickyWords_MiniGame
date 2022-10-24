package com.justjump.trickywords.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.justjump.trickywords.ui.components.home.LogoComp
import com.justjump.trickywords.ui.components.home.MainOptionsComp
import com.justjump.trickywords.ui.components.home.TitleAppComp

@Composable
fun HomeScreen() {
    Scaffold() { it
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            // Title
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                TitleAppComp("TrickyWords")
            }

            // Logo
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                LogoComp()
            }

            // Main Menu
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                MainOptionsComp()
            }
        }
    }
}