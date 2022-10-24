package com.justjump.trickywords.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.justjump.trickywords.ui.screens.HomeScreen
import com.justjump.trickywords.ui.theme.TrickyWordsAppTheme

@Composable
fun NavigationHost(navController: NavHostController) {
    TrickyWordsAppTheme {
        NavHost(navController = navController, NavItem.Home.baseRoute)
        {
            composable(route = NavItem.Home.route){ HomeScreen() }
        }
    }
}