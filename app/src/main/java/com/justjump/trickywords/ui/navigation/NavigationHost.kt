package com.justjump.trickywords.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.justjump.trickywords.ui.screens.HomeScreen
import com.justjump.trickywords.ui.screens.ProgressScreen
import com.justjump.trickywords.ui.screens.SelectBookScreen
import com.justjump.trickywords.ui.screens.SettingsScreen
import com.justjump.trickywords.ui.theme.TrickyWordsAppTheme

@Composable
fun NavigationHost(navController: NavHostController, onClickClose: () -> Unit) {
    TrickyWordsAppTheme {
        NavHost(navController = navController, NavItem.Home.baseRoute)
        {
            // Home screen to show the main options
            composable(route = NavItem.Home.route) {
                // this home screen control the events to jump to the different screens
                HomeScreen(
                    { navController.navigate(NavItem.SelectBook.route) },
                    { navController.navigate(NavItem.Progress.route) },
                    { navController.navigate(NavItem.Settings.route) },
                    { onClickClose() }
                )
            }

            // Selector of the book for the test
            composable(route = NavItem.SelectBook.route) {
                SelectBookScreen { navController.popBackStack() }
            }

            // Progress Screen
            composable(route = NavItem.Progress.route) {
                ProgressScreen { navController.popBackStack() }
            }

            // Settings
            composable(route = NavItem.Settings.route) {
                SettingsScreen { navController.popBackStack() }
            }
        }
    }
}