package com.justjump.trickywords.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.justjump.trickywords.ui.navigation.NavigationHost

@Composable
fun MainScreen(onClickClose: () -> Unit) {
    Scaffold { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavigationHost(rememberNavController(), onClickClose)
        }
    }
}