package com.justjump.trickywords.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.justjump.trickywords.ui.screens.*
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
                    { navController.navigate(NavItem.SelectBook.createNavRouter(it)) },
                    { navController.navigate(NavItem.Progress.route) },
                    { navController.navigate(NavItem.Settings.route) },
                    { onClickClose() }
                )
            }

            // Selector of the book for the test
            composable(
                route = NavItem.SelectBook.route,
                arguments = NavItem.SelectBook.args
            ) { backStackEntry ->
                val gameModeValue = backStackEntry.arguments?.getInt(NavArg.gameMode.Key)!!

                Log.e("Jesr2104", "${gameModeValue}")

                SelectBookScreen(
                    gameModeValue,
                    { navController.navigate(NavItem.PlayGame.createNavRouter(it)) },
                    { navController.popBackStack() }
                )
            }

            // Progress Screen
            composable(route = NavItem.Progress.route) {
                ProgressScreen { navController.popBackStack() }
            }

            // Settings
            composable(route = NavItem.Settings.route) {
                SettingsScreen { navController.popBackStack() }
            }

            composable(
                route = NavItem.PlayGame.route,
                arguments = NavItem.PlayGame.args
            ){ backStackEntry ->
                val gameModeValue = backStackEntry.arguments?.getInt(NavArg.esto.Key)!!
                PlayGame(gameModeValue)
            }
        }
    }
}