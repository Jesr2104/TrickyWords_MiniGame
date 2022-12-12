package com.justjump.trickywords.ui.navigation

sealed class NavItem(val route: String) {
    //----------------------------------------------------------------------
    // list of routes
    //----------------------------------------------------------------------
    object Home : NavItem("home")
    object SetGameOption : NavItem("setGameOption")

    object Play : NavItem("playGame")
    object Battle : NavItem("battleGame")
    object WordList : NavItem("wordList")

    object Progress : NavItem("progress")
    object Settings : NavItem("settings")
}