package com.justjump.trickywords.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.justjump.trickywords.domain.InfoPlayGame
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

            // Selector of the book for the test this one is for: Play / Battle / WordList
            composable(
                route = NavItem.SelectBook.route,
                arguments = NavItem.SelectBook.args
            ) { backStackEntry ->
                val gameModeValue = backStackEntry.arguments?.getInt(NavArg.GameMode.Key)!!
                SelectBookScreen(
                    gameModeValue,
                    {
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            key = "infoGame",
                            value = it
                        )
                        navController.navigate(NavItem.PlayGame.route)
                    },
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

            // Windows to chose between: Difficult -> Play / Battle / WordList
            composable(route = NavItem.PlayGame.route) {
                PlayGame(
                    navController.previousBackStackEntry?.savedStateHandle?.get<InfoPlayGame>("infoGame")
                ) { navController.popBackStack() }
            }
        }
    }
}