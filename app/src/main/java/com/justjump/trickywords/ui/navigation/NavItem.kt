package com.justjump.trickywords.ui.navigation

import androidx.navigation.NavType

sealed class NavItem(
    val baseRoute: String,
    private val navArgs: List<NavArg> = emptyList(),
) {

    // don't forget to specify the list of parameters
    //----------------------------------------------------------------------
    // list of routes
    //----------------------------------------------------------------------
        object Home : NavItem("home_screen")
        object SelectBook : NavItem("select_book")

    //----------------------------------------------------------------------

    // this run create the navigation route with its parameters
    // for eg: baseRoute/{param1}...
    val route = run {
        val argKeys = navArgs.map { "{${it.Key}}" }
        listOf(baseRoute)
            .plus(argKeys)
            .joinToString("/")
    }
}

enum class NavArg(val Key: String, val navType: NavType<*>){
}