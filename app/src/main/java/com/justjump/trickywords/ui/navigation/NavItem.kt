package com.justjump.trickywords.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavItem(
    val baseRoute: String,
    private val navArgs: List<NavArg> = emptyList(),
) {
    // don't forget to specify the list of parameters
    //----------------------------------------------------------------------
    // list of routes
    //----------------------------------------------------------------------
        object Home : NavItem("home")
        object SelectBook : NavItem("selectBook", listOf(NavArg.GameMode)){
            fun createNavRouter(gameMode: Int) = "$baseRoute/${gameMode}"
        }
        object PlayGame : NavItem("playGame")
        object BattleGame : NavItem("battleGame")
        object WordList : NavItem("wordList")

        object Progress : NavItem("progress")
        object Settings : NavItem("settings")
    //----------------------------------------------------------------------
    // this run create the navigation route with its parameters
    // for eg: baseRoute/{param1}...
    val route = run {
        val argKeys = navArgs.map { "{${it.Key}}" }
        listOf(baseRoute)
            .plus(argKeys)
            .joinToString("/")
    }
    val args = navArgs.map { navArgument(it.Key) { type = it.navType } }
}
enum class NavArg(val Key: String, val navType: NavType<*>){
    GameMode("gameMode", NavType.IntType),
}