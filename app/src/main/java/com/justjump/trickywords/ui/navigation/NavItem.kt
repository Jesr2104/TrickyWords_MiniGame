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
        object SelectBook : NavItem("select_book", listOf(NavArg.GameMode)){
            fun createNavRouter(gameMode: Int) = "$baseRoute/${gameMode}"
        }
        object Progress : NavItem("progress")
        object Settings : NavItem("settings")

        object PlayGame : NavItem("play_game")/*, listOf(NavArg.esto)){
            fun createNavRouter(esto: Int) = "$baseRoute/${esto}"
        }*/
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
    esto("gameMode", NavType.IntType)
}