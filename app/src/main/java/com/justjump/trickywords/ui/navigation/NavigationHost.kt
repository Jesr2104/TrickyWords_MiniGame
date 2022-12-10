package com.justjump.trickywords.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.justjump.trickywords.domain.datamodels.SetGame
import com.justjump.trickywords.ui.screens.*
import com.justjump.trickywords.ui.theme.TrickyWordsAppTheme
import com.justjump.trickywords.utilities.passOnDataGet
import com.justjump.trickywords.utilities.passOnDataSet

// Key for Object to configure game!!
const val KEY_SET_GAME = "setGame" // SetGame type value
const val KEY_MODE_GAME = "modeSelected" // integer value

@Composable
fun NavigationHost(navController: NavHostController, onClickClose: () -> Unit) {
    TrickyWordsAppTheme {
        NavHost(navController = navController, NavItem.Home.route)
        {
            // Home screen to show the main options
            // ---------------------------------------
            composable(route = NavItem.Home.route) {
                // this home screen control the events to jump to the different screens
                HomeScreen(
                    {
                        navController.passOnDataSet(key = KEY_MODE_GAME, value = it)
                        navController.navigate(NavItem.SetGameOption.route)
                    },
                    { navController.navigate(NavItem.Progress.route) },
                    { navController.navigate(NavItem.Settings.route) },
                    { onClickClose() }
                )
            }

            // SelectBook Screen
            composable(route = NavItem.SetGameOption.route){
                SetGameOptionScreen(
                    // operator ?: elvis to set the default value in zero
                    navController.passOnDataGet<Int>(KEY_MODE_GAME)?:0
                ){ navController.popBackStack() }
            }

            // PlayGame Screen
            composable( route = NavItem.PlayGame.route){
                PlayGameScreen(navController.passOnDataGet<SetGame>(KEY_SET_GAME))
                { navController.popBackStack() }
            }

            // Progress Screen
            composable(route = NavItem.Progress.route) {
                ProgressScreen { navController.popBackStack() }
            }

            // Settings Screen
            composable(route = NavItem.Settings.route) {
                SettingsScreen { navController.popBackStack() }
            }















            /*// Selector of the book for the test this one is for: Play / Battle / WordList
            composable(route = NavItem.SelectBook.route) {
                SelectBookScreen(
                    // get the gameMode selected and send this to the book select
                    navController.passOnDataGet<Int>(KEY_MODE_GAME)!!,
                    {
                        navController.passOnDataSet(key = KEY_SET_GAME, value = it)
                        navController.navigate(NavItem.SelectDifficulty.route)
                    },
                    { navController.popBackStack() }
                )
            }

            // Windows to chose between: Difficult to -> PlayGame / Battle / WordList
            composable(route = NavItem.SelectDifficulty.route) {
                SelectDifficultyScreen(
                    navController.passOnDataGet<SetGame>(KEY_SET_GAME),
                    {
                        navController.passOnDataSet(
                            key = KEY_SET_GAME,
                            value = navController.passOnDataGet<SetGame>(KEY_SET_GAME)
                        )
                        navController.navigate(NavItem.PlayGame.route)
                    },
                    { navController.popBackStack() }
                )
            }

            // PlayGame Screen
            composable( route = NavItem.PlayGame.route){
                PlayGameScreen(navController.passOnDataGet<SetGame>(KEY_SET_GAME))
                { navController.popBackStack() }
            }

            // Progress Screen
            composable(route = NavItem.Progress.route) {
                ProgressScreen { navController.popBackStack() }
            }

            // Settings Screen
            composable(route = NavItem.Settings.route) {
                SettingsScreen { navController.popBackStack() }
            }*/
        }
    }
}

