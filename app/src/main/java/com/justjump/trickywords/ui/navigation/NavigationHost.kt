package com.justjump.trickywords.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.justjump.trickywords.domain.datamodels.GameDataModel
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
            composable(route = NavItem.SetGameOption.route) {
                SetGameOptionScreen(
                    // operator ?: elvis to set the default value in zero
                    navController.passOnDataGet<Int>(KEY_MODE_GAME) ?: 0,
                    {
                        navController.passOnDataSet(KEY_SET_GAME, it)
                        navController.navigate(NavItem.Play.route)
                    },
                    { navController.navigate(NavItem.Battle.route) },
                    { navController.navigate(NavItem.WordList.route) },
                    { navController.popBackStack() }
                )
            }

            // Play Screen
            composable(route = NavItem.Play.route) {
                val setGame = navController.passOnDataGet<GameDataModel>(KEY_SET_GAME)
                PlayScreen(
                    setGame,
                    { navController.popBackStack(NavItem.Home.route, false) },
                    { navController.popBackStack() }
                )
            }

            // Battle Screen
            composable(route = NavItem.Battle.route) {
                BattleScreen()
                { navController.popBackStack() }
            }

            // WordList Screen
            composable(route = NavItem.WordList.route) {
                WordListScreen()
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
        }
    }
}

